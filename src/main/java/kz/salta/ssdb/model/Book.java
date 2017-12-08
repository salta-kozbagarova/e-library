package kz.salta.ssdb.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2003639787531240220L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="book_id_seq")
	@SequenceGenerator(name="book_id_seq", sequenceName="book_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "author")
    private String author;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "publisher_id", nullable = true)
	private Publisher publisher;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "city_id", nullable = true)
	private City city;
	
	@Column(name="published_year")
	private Integer published_year;
	
	@Column(name="pages")
	private Integer pages;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "genre_id", nullable = true)
	private Genre genre;
	
	@Column(name="quantity")
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getPublishedYear() {
		return published_year;
	}

	public void setPublishedYear(Integer published_year) {
		this.published_year = published_year;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
