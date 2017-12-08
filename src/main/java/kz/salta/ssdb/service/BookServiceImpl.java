package kz.salta.ssdb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salta.ssdb.dao.BookDao;
import kz.salta.ssdb.dao.LogbookDao;
import kz.salta.ssdb.dao.UserDao;
import kz.salta.ssdb.model.Book;
import kz.salta.ssdb.model.Logbook;
import kz.salta.ssdb.model.User;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Resource(name = "securityService")
    private SecurityService securityService;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private LogbookDao logbookDao;
	
	@Autowired
    private UserDao userDao;
	
	@Override
	public Book findOne(Long id) {
		return bookDao.findOne(id);
	}
	
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public void takeBook(Long id) {
		Book book = bookDao.findOne(id);
		Integer newQuantity=book.getQuantity()-1;
		book.setQuantity(newQuantity);
		bookDao.save(book);
	}

	@Override
	public List<Book> booksToReturnForCurrentUser() {
		String username = securityService.findLoggedInUsername();
		User user = userDao.findByUsername(username);
		List<Book> books = bookDao.findCheckedOutByLibraryCardOfCurrentUser(user.getLibraryCard().getId());
		return books;
	}

	@Override
	public void returnBook(Long id) {
		Book book = bookDao.findOne(id);
		Integer newQuantity=book.getQuantity()+1;
		book.setQuantity(newQuantity);
		bookDao.save(book);
	}

}
