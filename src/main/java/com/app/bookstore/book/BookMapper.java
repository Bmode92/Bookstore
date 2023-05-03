package com.app.bookstore.book;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

	public Book bookCreateDTO2Book(BookCreateDTO bookCreateDTO) {
		Book book = new Book();
		book.setName(bookCreateDTO.getName());
		book.setPrice(bookCreateDTO.getPrice());
		book.setTitle(bookCreateDTO.getTitle());

		return book;
	}

	public BookGetDTO book2BookGetDTO(Book book) {
		BookGetDTO bookGetDTO = new BookGetDTO();
		bookGetDTO.setId(book.getId());
		bookGetDTO.setName(book.getName());
		bookGetDTO.setTitle(book.getTitle());
		bookGetDTO.setPrice(book.getPrice());

		return bookGetDTO;
	}

}
