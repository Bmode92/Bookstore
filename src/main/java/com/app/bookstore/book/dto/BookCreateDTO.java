package com.app.bookstore.book.dto;

import java.time.LocalDate;
import java.util.List;

public class BookCreateDTO {
	private String title;
	private String isbn;
	private LocalDate year;
	private List<Integer> authorsIds;

	public List<Integer> getAuthorsIds() {
		return authorsIds;
	}

	public void setAuthorsIds(List<Integer> authorsIds) {
		this.authorsIds = authorsIds;
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

}
