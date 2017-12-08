package kz.salta.ssdb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kz.salta.ssdb.model.Book;
import kz.salta.ssdb.model.LibraryCard;

public interface BookDao extends JpaRepository<Book, Long> {

	@Query(value="SELECT b.* FROM Book b, Logbook l WHERE b.id=l.book_id AND l.library_card_id=:library_card_id AND actiontype='checked_out'", nativeQuery = true)
	List<Book> findCheckedOutByLibraryCardOfCurrentUser(@Param("library_card_id") Long libraryCardId);
	
}
