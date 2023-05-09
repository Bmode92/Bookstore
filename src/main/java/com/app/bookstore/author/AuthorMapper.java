package com.app.bookstore.author;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

	public Author authorCreateDTO2Author(AuthorCreateDTO authorCreateDTO) {
		Author author = new Author();
		author.setTitle(authorCreateDTO.getTitle());
		author.setYear(authorCreateDTO.getYear());
		author.setIsbn(authorCreateDTO.getIsbn());

		return author;
	}

	public AuthorGetDTO author2authorGetDTO(Author author) {
		AuthorGetDTO authorGetDTO = new AuthorGetDTO();
		authorGetDTO.setId(author.getId());
		authorGetDTO.setTitle(author.getTitle());
		authorGetDTO.setYear(author.getYear());
		authorGetDTO.setIsbn(author.getIsbn());

		return authorGetDTO;
	}

	public List<AuthorGetDTO> listAuthor2listGetDTO(List<Author> authors) {
		return authors.stream().map(author -> author2authorGetDTO(author)).toList();
	}

}
