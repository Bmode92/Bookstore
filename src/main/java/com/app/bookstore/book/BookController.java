package com.app.bookstore.book;

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

import com.app.bookstore.book.dto.BookCreateDTO;
import com.app.bookstore.book.dto.BookGetDTO;
import com.app.bookstore.book.dto.BookWithExemplariesDTO;
import com.app.bookstore.book.mapper.BookMapper;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookMapper bookMapper;

	@PostMapping
	public ResponseEntity<BookGetDTO> createWithStatus(@RequestBody BookCreateDTO bookCreateDTO) {
		Book book = bookService.create(bookMapper.bookCreateDTO2Book(bookCreateDTO));
		return new ResponseEntity<>(bookMapper.book2BookGetDTO(book), HttpStatus.CREATED);
	}

//	@PostMapping()
//	public BookGetDTO create(@RequestBody BookCreateDTO bookCreateDTO) {
//		Book book = bookMapper.bookCreateDTO2Book(bookCreateDTO);
//		Book createdBook = bookService.create(book);
//
//		return bookMapper.book2BookGetDTO(createdBook);
//	}

	@GetMapping("/{id}")
	public BookGetDTO findById(@PathVariable Integer id) {
		Book book = bookService.findById(id);
		return bookMapper.book2BookGetDTO(book);
	}

	@GetMapping()
	public List<BookGetDTO> findAll() {
		return bookService.findAll().stream().map(book -> bookMapper.book2BookGetDTO(book)).toList();
	}

	@GetMapping("/name/{name}")
	public List<BookGetDTO> findByTitle(@PathVariable String title) {
		return bookMapper.listBook2listGetDTO(bookService.findByTitle(title));

	}

	// duce la n+1 select problem (1 query pentru parinte, n query-uri pentru
	// fiecare parinte (n = numarul de parinti))
	@GetMapping("/list-with-exemplaries")
	public List<BookWithExemplariesDTO> findAllWithExemplaries() {
		return bookMapper.bookList2BooksWithExemplariesDTO(bookService.findAll());
	}

	@PutMapping("/{id}")
	public BookGetDTO update(@RequestBody BookCreateDTO bookCreateDTO, @PathVariable Integer id) {
		Book book = bookMapper.bookCreateDTO2Book(bookCreateDTO);
		Book updatedBook = bookService.update(book, id);

		return bookMapper.book2BookGetDTO(updatedBook);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		bookService.delete(id);
	}

}
