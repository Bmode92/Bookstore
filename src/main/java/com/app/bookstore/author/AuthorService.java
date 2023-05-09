package com.app.bookstore.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public Author create(Author author) {
		return authorRepository.save(author);
	}

	public Author findById(Integer id) {
		return authorRepository.findById(id).orElseThrow();
	}

	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	public Author update(Author bookToUpdate, Integer authorId) {
		Author existingAuthor = authorRepository.findById(authorId).orElseThrow();
		existingAuthor.setTitle(bookToUpdate.getTitle());
		existingAuthor.setIsbn(bookToUpdate.getIsbn());
		existingAuthor.setYear(bookToUpdate.getYear());

		return authorRepository.save(existingAuthor);
	}

	public void delete(Integer authorId) {
		authorRepository.deleteById(authorId);
	}

	public List<Author> findByTitle(String title) {
		return authorRepository.findByTitle(title);
	}

}
