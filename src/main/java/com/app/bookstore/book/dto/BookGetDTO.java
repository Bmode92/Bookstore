package com.app.bookstore.book.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.bookstore.author.dto.AuthorGetDTO;

public class BookGetDTO {
	private Integer id;
	private String title;
	private String isbn;
	private LocalDate year;
	private List<AuthorGetDTO> authors;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public List<AuthorGetDTO> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorGetDTO> authors) {
		this.authors = authors;
	}

}
