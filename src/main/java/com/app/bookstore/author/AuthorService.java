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

	public Author update(Author authorToUpdate, Integer authorId) {
		Author existingAuthor = authorRepository.findById(authorId).orElseThrow();
		existingAuthor.setName(authorToUpdate.getName());
		existingAuthor.setBirthDate(authorToUpdate.getBirthDate());
		existingAuthor.setDeathDate(authorToUpdate.getDeathDate());
		existingAuthor.setGender(authorToUpdate.getGender());
		existingAuthor.setNationality(authorToUpdate.getNationality());

		return authorRepository.save(existingAuthor);
	}

	public void delete(Integer authorId) {
		authorRepository.deleteById(authorId);
	}

	public List<Author> findByName(String name) {
		return authorRepository.findByName(name);
	}

}
