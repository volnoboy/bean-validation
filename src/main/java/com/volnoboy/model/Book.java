package com.volnoboy.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.volnoboy.validator.NotEmpty;
import org.hibernate.validator.constraints.URL;

/**
 * @author Volodymyr Volnoboy
 * @since 2/14/16 6:20 PM
 */
public class Book {

	@Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$")
	private String isbn;

	@NotEmpty
	private String title;

	@NotNull
	@Min(2)
	private Float price;

	@Size(min = 10, max = 2000)
	private String description;

	private Integer nbOfPage;

	@Past
	private Date dateOfPublication;

	@URL
	private String bookURL;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@NotEmpty
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getBookURL() {
		return bookURL;
	}

	public void setBookURL(String bookURL) {
		this.bookURL = bookURL;
	}

	public Book(String isbn, String title, Float price, String description, Integer nbOfPage, Date dateOfPublication, String bookURL) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.description = description;
		this.nbOfPage = nbOfPage;
		this.dateOfPublication = dateOfPublication;
		this.bookURL = bookURL;
	}

	public Book() {
	}
}
