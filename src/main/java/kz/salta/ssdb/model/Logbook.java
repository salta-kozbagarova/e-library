package kz.salta.ssdb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


@Entity
@Table(name="logbook")
public class Logbook implements Serializable{
	
	public final static Integer IN_THE_HALL=1;
	public final static Integer ON_THE_HANDS=2;
	
	private static final long serialVersionUID = 3643346291148074660L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="logbook_id_seq")
	@SequenceGenerator(name="logbook_id_seq", sequenceName="logbook_id_seq", allocationSize=1)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "library_card_id", nullable = true)
	private LibraryCard libraryCard;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = true)
	private Book book;
	
	@Column(name="book_issuing_type")
	private Integer book_issuing_type;
	
	@Column(name="check_out_date", nullable=true)
	private Date checkOutDate;
	
	@Column(name="return_date", nullable=true)
	private Date returnDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LibraryCard getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(LibraryCard libraryCard) {
		this.libraryCard = libraryCard;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getBookIssuingType() {
		return getBookIssuingTypes().get(book_issuing_type);
	}

	public void setBookIssuingType(Integer book_issuing_type_id) {
		this.book_issuing_type = book_issuing_type_id;
	}

	public static HashMap<Integer,String> getBookIssuingTypes() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("classpath:messages");
		ms.setDefaultEncoding("UTF-8");
		Locale locale = LocaleContextHolder.getLocale();
		HashMap<Integer,String> bookIssuingTypes = new HashMap<Integer,String>();
		bookIssuingTypes.put(IN_THE_HALL, ms.getMessage("book.in_the_hall", null, locale));
		bookIssuingTypes.put(ON_THE_HANDS, ms.getMessage("book.on_the_hands", null, locale));
		return bookIssuingTypes;
	}
	
}
