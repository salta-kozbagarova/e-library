package kz.salta.ssdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salta.ssdb.dao.LibraryCardDao;
import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.User;


@Service("libraryCardService")
public class LibraryCardServiceImpl implements LibraryCardService {
	
	@Autowired
	private LibraryCardDao libraryCardDao;
	
	@Override
	public void saveWithUser(LibraryCard libraryCard, User user) {
		libraryCard.setUser(user);
		libraryCardDao.save(libraryCard);
	}

	@Override
	public List<LibraryCard> findAll() {
		return libraryCardDao.findAll();
	}

	@Override
	public void save(LibraryCard libraryCard) {
		libraryCardDao.save(libraryCard);
	}

	@Override
	public LibraryCard findOne(Long id) {
		return libraryCardDao.findOne(id);
	}
	
}
