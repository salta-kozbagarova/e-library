package kz.salta.ssdb.form;

import org.springframework.web.multipart.MultipartFile;

import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.User;

public class ProfileForm {
	
	private User user;
	
	private LibraryCard libraryCard;
	
	private MultipartFile file;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LibraryCard getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(LibraryCard libraryCard) {
		this.libraryCard = libraryCard;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
