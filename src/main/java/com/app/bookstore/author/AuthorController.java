package com.app.bookstore.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.book.Book;
import com.app.bookstore.book.BookCreateDTO;
import com.app.bookstore.book.BookGetDTO;
import com.app.bookstore.book.BookMapper;
import com.app.bookstore.book.BookService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private AuthorMapper authorMapper;

	@PostMapping
	public ResponseEntity<AuthorGetDTO> createWithStatus(@RequestBody AuthorCreateDTO authorCreateDTO) {
		Author author = authorService.create(authorMapper.authorCreateDTO2Author(authorCreateDTO));
		return new ResponseEntity<>(authorMapper.author2authorGetDTO(author), HttpStatus.CREATED);
	}

	@PostMapping()
	public AuthorGetDTO create(@RequestBody AuthorCreateDTO authorCreateDTO) {
		Author author = authorMapper.authorCreateDTO2Author(authorCreateDTO);
		Author createdAuthor = authorService.create(author);

		return authorMapper.author2authorGetDTO(createdAuthor);
	}

	@GetMapping("/{id}")
	public Author findById(@PathVariable Integer id) {
		return authorService.findById(id);
	}

	@GetMapping()
	public List<AuthorGetDTO> findAll() {
		return authorService.findAll().stream().map(author -> authorMapper.author2authorGetDTO(author)).toList();
	}

	@PutMapping("/{id}")
	public AuthorGetDTO update(@RequestBody AuthorCreateDTO authorCreateDTO, @PathVariable Integer id) {
		Author author = authorMapper.authorCreateDTO2Author(authorCreateDTO);
		Author updatedAuthor = authorService.update(author, id);

		return authorMapper.author2authorGetDTO(updatedAuthor);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		authorService.delete(id);
	}

	@GetMapping("/name")
	public List<AuthorGetDTO> findByTitle(@RequestParam String title) {
		return authorMapper.listAuthor2listGetDTO(authorService.findByTitle(title));

	}

}
