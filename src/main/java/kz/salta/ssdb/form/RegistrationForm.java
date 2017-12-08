package kz.salta.ssdb.form;

import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.User;

public class RegistrationForm {
	
	private User user;
	
	private LibraryCard libraryCard;

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
}
