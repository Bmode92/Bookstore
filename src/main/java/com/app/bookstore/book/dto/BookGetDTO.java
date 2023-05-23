package com.app.bookstore.book.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class BookGetDTO {
	private Integer id;
	private String title;
	private String isbn;
	private LocalDate year;

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

}
