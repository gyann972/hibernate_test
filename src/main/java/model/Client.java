package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	public Client(String name, String firstname, char gender, Book favouriteBook) {
		this.name = name;
		this.firstname = firstname;
		this.gender = gender;
		this.favouriteBook = favouriteBook;
	}
	
	public Client(String name, String firstname, char gender) {
		this.name = name;
		this.firstname = firstname;
		this.gender = gender;
	}
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String firstname;
	
	@Column
	private char gender;

	@ManyToOne
	private Book favouriteBook;
	
	@ManyToMany
	private List<Book> purchasedBooks = new ArrayList<Book>();
	
	public List<Book> getPurchasedBooks() {
		return purchasedBooks;
	}

	public void setPurchasedBooks(List<Book> purchasedBooks) {
		this.purchasedBooks = purchasedBooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Book getFavouriteBook() {
		return favouriteBook;
	}

	public void setFavouriteBook(Book favouriteBook) {
		this.favouriteBook = favouriteBook;
	}

	public Long getId() {
		return id;
	}
}
