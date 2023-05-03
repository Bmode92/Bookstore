package com.app.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book create(Book book) {
		return bookRepository.save(book);
	}

	public Book findById(Integer id) {
		return bookRepository.findById(id).orElseThrow();
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book update(Book bookToUpdate, Integer bookId) {
		Book existingBook = bookRepository.findById(bookId).orElseThrow();
		existingBook.setName(bookToUpdate.getName());
		existingBook.setTitle(bookToUpdate.getTitle());
		existingBook.setPrice(bookToUpdate.getPrice());

		return bookRepository.save(existingBook);
	}

	public void delete(Integer bookId) {
		bookRepository.deleteById(bookId);
	}

}
