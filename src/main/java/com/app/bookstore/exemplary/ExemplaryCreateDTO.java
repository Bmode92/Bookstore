package com.app.bookstore.exemplary;

import java.time.LocalDate;

public class ExemplaryCreateDTO {
	private LocalDate date;
	private String code;
	private Integer pageNumbers;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(Integer pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

}
