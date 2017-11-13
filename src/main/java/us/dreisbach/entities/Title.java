package us.dreisbach.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Title {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	@Size(max=17)
	private String isbn;

	@NotNull
	@Size(max=255)
	private String title;
	
	private Integer yearPublished;
	
	@ManyToMany
    @JoinTable
	private Set<Author> authors;
	
	@ManyToOne
	private Publisher publisher;
	
	@OneToMany(mappedBy = "title")
	private Set<Book> bookCopies;
	
	@Min(0)
	@Max(9)
	private Integer ddcClass;
	
	@Min(0)
	@Max(9)
	private Integer ddcDivision;
	
	@Min(0)
	@Max(9)
	private Integer ddcSection;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(Integer yearPublished) {
		this.yearPublished = yearPublished;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Book> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(Set<Book> bookCopies) {
		this.bookCopies = bookCopies;
	}
}
