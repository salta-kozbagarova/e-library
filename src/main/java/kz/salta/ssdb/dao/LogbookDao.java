package kz.salta.ssdb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.salta.ssdb.model.LibraryCard;
import kz.salta.ssdb.model.Logbook;

public interface LogbookDao extends JpaRepository<Logbook, Long> {
	
	List<Logbook> findByLibraryCardAndReturnDateIsNull(LibraryCard libraryCard);
}
