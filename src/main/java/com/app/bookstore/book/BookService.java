package com.app.bookstore.book;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.author.Author;
import com.app.bookstore.author.AuthorRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public Book create(Book book, List<Integer> authorsID) {
		List<Author> authors = authorRepository.findAllById(authorsID);
		Set<Author> authorsSet = new HashSet<>(authors);
		
		authors.stream().forEach(author -> author.addBook(book));
		book.setAuthors(authorsSet);
		
		return bookRepository.save(book);
	}

	public Book findById(Integer id) {
		return bookRepository.findById(id).orElseThrow();
	}

	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book update(Book bookToUpdate, Integer bookId) {
		Book existingBook = bookRepository.findById(bookId).orElseThrow();
		existingBook.setTitle(bookToUpdate.getTitle());
		existingBook.setIsbn(bookToUpdate.getIsbn());
		existingBook.setYear(bookToUpdate.getYear());

		return bookRepository.save(existingBook);
	}

	public void delete(Integer bookId) {
		bookRepository.deleteById(bookId);
	}

}
