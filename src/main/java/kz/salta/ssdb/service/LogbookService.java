package kz.salta.ssdb.service;

import java.util.List;

import kz.salta.ssdb.model.Book;
import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.Logbook;

public interface LogbookService {
	
	Logbook findOne(Long id);
	
	List<Logbook> findAll();
	
	void addRecord(Long book_id);
	void addRecord(Long book_id, Long library_card_id);
	void updateRecord(Long logbook_id);
	
	List<Logbook> findByLibraryCardAndReturnDateIsNull();
}
