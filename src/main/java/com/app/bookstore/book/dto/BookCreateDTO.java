package com.app.bookstore.book.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.lang.NonNull;

import com.app.bookstore.exception.AdvanceInfo;
import com.app.bookstore.exception.BasicInfo;
import com.app.bookstore.exception.ValidYear;

import jakarta.validation.constraints.NotNull;

public class BookCreateDTO {
	@NotNull(groups = BasicInfo.class)
	private String title;
	private String isbn;
	@NotNull(groups = BasicInfo.class)
	@ValidYear(groups = AdvanceInfo.class)
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
