package kz.salta.ssdb.service;

import java.util.List;

import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.User;

public interface LibraryCardService {
	
	void saveWithUser(LibraryCard libraryCard, User user);
	
	List<LibraryCard> findAll();
	
	void save(LibraryCard libraryCard);
	
	LibraryCard findOne(Long id);
}
