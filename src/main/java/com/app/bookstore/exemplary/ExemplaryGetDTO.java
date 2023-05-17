package com.app.bookstore.exemplary;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class ExemplaryGetDTO {

	private Integer id;
	private LocalDate date;
	private String code;
	private Integer pageNumbers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
