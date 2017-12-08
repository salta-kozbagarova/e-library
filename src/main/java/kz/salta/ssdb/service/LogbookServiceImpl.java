package kz.salta.ssdb.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salta.ssdb.dao.BookDao;
import kz.salta.ssdb.dao.LibraryCardDao;
import kz.salta.ssdb.dao.LogbookDao;
import kz.salta.ssdb.dao.UserDao;
import kz.salta.ssdb.model.Book;
import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.Logbook;
import kz.salta.ssdb.model.User;

@Service("logbookService")
public class LogbookServiceImpl implements LogbookService {
	
	@Resource(name = "securityService")
    private SecurityService securityService;
	
	@Autowired
	private LogbookDao logbookDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
    private UserDao userDao;
	
	@Autowired
    private LibraryCardDao libraryCardDao;

	@Override
	public Logbook findOne(Long id) {
		return logbookDao.findOne(id);
	}
	
	@Override
	public List<Logbook> findAll() {
		return logbookDao.findAll();
	}

	@Override
	public void addRecord(Long book_id) {
		Logbook logbook=new Logbook();
		String username = securityService.findLoggedInUsername();
		User user = userDao.findByUsername(username);
		Book book = bookDao.findOne(book_id);
		logbook.setLibraryCard(user.getLibraryCard());
		logbook.setBook(book);
		if(book.getQuantity()<=5){
			logbook.setBookIssuingType(Logbook.IN_THE_HALL);
		}else{
			logbook.setBookIssuingType(Logbook.ON_THE_HANDS);
		}
		logbook.setCheckOutDate(new Date());
		logbookDao.save(logbook);
	}
	
	@Override
	public void addRecord(Long book_id, Long library_card_id) {
		Logbook logbook=new Logbook();
		Book book = bookDao.findOne(book_id);
		logbook.setLibraryCard(libraryCardDao.findOne(library_card_id));
		logbook.setBook(book);
		if(book.getQuantity()<=5){
			logbook.setBookIssuingType(Logbook.IN_THE_HALL);
		}else{
			logbook.setBookIssuingType(Logbook.ON_THE_HANDS);
		}
		logbook.setCheckOutDate(new Date());
		logbookDao.save(logbook);
	}

	@Override
	public void updateRecord(Long logbook_id) {
		Logbook logbook = logbookDao.findOne(logbook_id);
		logbook.setReturnDate(new Date());
		logbookDao.save(logbook);
	}

	@Override
	public List<Logbook> findByLibraryCardAndReturnDateIsNull() {
		String username = securityService.findLoggedInUsername();
		User user = userDao.findByUsername(username);
		List<Logbook> logbooks = logbookDao.findByLibraryCardAndReturnDateIsNull(user.getLibraryCard());
		return logbooks;
	}

}
