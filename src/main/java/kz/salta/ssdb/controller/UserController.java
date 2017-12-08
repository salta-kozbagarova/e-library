package kz.salta.ssdb.controller;

import kz.salta.ssdb.form.ProfileForm;
import kz.salta.ssdb.form.RegistrationForm;
import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.User;
import kz.salta.ssdb.service.BookService;
import kz.salta.ssdb.service.LibraryCardService;
import kz.salta.ssdb.service.SecurityService;
import kz.salta.ssdb.service.UserService;
import kz.salta.ssdb.validator.RegistrationFormValidator;
import kz.salta.ssdb.validator.UserValidator;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UserController {

	@Resource(name = "userService")
    private UserService userService;

	@Resource(name = "securityService")
    private SecurityService securityService;
	
	@Resource(name = "libraryCardService")
    private LibraryCardService libraryCardService;
	
	@Resource(name = "bookService")
    private BookService bookService;

    @Autowired
    private RegistrationFormValidator registrationFormValidator;
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
    		BindingResult registrationResult, Model model) {
    	//registrationFormValidator.validate(registrationForm, registrationResult);
        if (registrationResult.hasErrors()) {
            return "/site/registration";
        }

        userService.save(registrationForm.getUser());

        securityService.autoLogin(registrationForm.getUser().getUsername(), registrationForm.getUser().getConfirmPassword());
        
        libraryCardService.saveWithUser(registrationForm.getLibraryCard(),registrationForm.getUser());

        return "redirect:/profile";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        model.addAttribute("registrationForm",new RegistrationForm());
        return "/site/login";
    }

    @RequestMapping(value = {"/", "/profile"}, method = RequestMethod.GET)
    public String profile(HttpServletRequest request, Model model) {
    	if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
    	ProfileForm profileForm = new ProfileForm();
    	profileForm.setUser(userService.getCurrentUser());
    	profileForm.setLibraryCard(userService.getCurrentUser().getLibraryCard());
    	model.addAttribute("profileForm",profileForm);
        return "/student/profile";
    }
    
    @RequestMapping(value = "/upload-image", method = RequestMethod.POST)
    public String uploadImage(@ModelAttribute("profileForm")ProfileForm profileForm,
    			Model model,
			   @RequestParam(value="id", required=true) Long id) {
    	MultipartFile file = profileForm.getFile();
    	if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dirToSave = new File("C:\\Users\\Администратор\\workspace5" + File.separator + "uploads");
				String filename = securityService.findLoggedInUsername()+System.currentTimeMillis()+"."+file.getOriginalFilename().split("\\.")[1];
				if (!dirToSave.exists())
					dirToSave.mkdirs();
				File serverFile = new File(dirToSave.getAbsolutePath()
						+ File.separator + filename);
				file.transferTo(serverFile);
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				System.out.println("You successfully uploaded file="+serverFile);
				
				LibraryCard libraryCard = libraryCardService.findOne(id);
				libraryCard.setImage(filename);
				libraryCardService.save(libraryCard);
			} catch (Exception e) {
				System.out.println("You failed to upload. Message: " + e.getMessage());
			}
		} else {
			System.out.println("You failed to upload because the file was empty.");
		}

        return "redirect:/profile";
    }
    
    @RequestMapping(value = "/uploads/{filename:.+}", method = RequestMethod.GET)
    public void uploads(@PathVariable String filename, HttpServletResponse response, HttpServletRequest request) throws Exception {
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        File imageFile = new File("C:\\Users\\Администратор\\workspace5" + File.separator + "uploads"+File.separator+filename);
    	try {
        	String path = imageFile.getAbsolutePath();
            InputStream is = new FileInputStream(path);
            BufferedImage image = ImageIO.read(is);
            ImageIO.write(image, "jpeg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
        	response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        
        byte[] imgByte = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(imgByte);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "/admin/admin";
    }
    
    
}
