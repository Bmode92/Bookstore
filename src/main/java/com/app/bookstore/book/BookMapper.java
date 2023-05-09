package com.app.bookstore.book;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

	public Book bookCreateDTO2Book(BookCreateDTO bookCreateDTO) {
		Book book = new Book();
		book.setTitle(bookCreateDTO.getTitle());
		book.setYear(bookCreateDTO.getYear());
		book.setIsbn(bookCreateDTO.getIsbn());

		return book;
	}

	public BookGetDTO book2BookGetDTO(Book book) {
		BookGetDTO bookGetDTO = new BookGetDTO();
		bookGetDTO.setId(book.getId());
		bookGetDTO.setTitle(book.getTitle());
		bookGetDTO.setYear(book.getYear());
		bookGetDTO.setIsbn(book.getIsbn());

		return bookGetDTO;
	}

	public List<BookGetDTO> listBook2listGetDTO(List<Book> books) {
		return books.stream().map(book -> book2BookGetDTO(book)).toList();
	}

}
