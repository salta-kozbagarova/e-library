package kz.salta.ssdb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.Logbook;
import kz.salta.ssdb.service.BookService;
import kz.salta.ssdb.service.LibraryCardService;
import kz.salta.ssdb.service.LogbookService;
import kz.salta.ssdb.service.UserService;

@Controller
public class AdminController {

	@Resource(name = "userService")
    private UserService userService;
	
	@Resource(name = "libraryCardService")
    private LibraryCardService libraryCardService;
	
	@Resource(name = "logbookService")
    private LogbookService logbookService;
	
	@Resource(name = "bookService")
    private BookService bookService;
	
	@RequestMapping(value = "/admin/library", method = RequestMethod.GET)
    public String library(Model model) {
    	model.addAttribute("books",bookService.findAll());
        return "/admin/library";
    }
	
	@RequestMapping(value = "/admin/give-a-book", method = RequestMethod.GET)
    public String giveABookForm(@RequestParam(value = "id", required = true) Long id, Model model) {
    	model.addAttribute("logbook",new Logbook());
    	model.addAttribute("bookId", id);
    	List<LibraryCard> libraryCards = libraryCardService.findAll();
    	model.addAttribute("libraryCards", libraryCards);
        return "/admin/give-a-book";
    }
	
	@RequestMapping(value = "/admin/give-a-book", method = RequestMethod.POST)
    public String giveABook(@ModelAttribute("logbook")  @Valid Logbook logbook, 
			BindingResult bindingResult, @RequestParam(value = "id", required = true) Long bookId, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "redirect:/admin/give-a-book";
		}
		
		logbookService.addRecord(bookId,logbook.getLibraryCard().getId());
		bookService.takeBook(bookId);
		return "redirect:/admin/library";
    }
}
