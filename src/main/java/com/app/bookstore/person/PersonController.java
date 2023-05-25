package com.app.bookstore.person;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.person.dto.PersonCreateDTO;
import com.app.bookstore.person.dto.PersonGetDTO;
import com.app.bookstore.person.mapper.PersonMapper;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonMapper personMapper;

	@PostMapping
	public ResponseEntity<PersonGetDTO> create(@RequestBody PersonCreateDTO personCreateDTO) {
		Person person = personService.create(personMapper.personCreateDTO2Person(personCreateDTO));
		return new ResponseEntity<>(personMapper.person2personGetDTO(person), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public PersonGetDTO findById(@PathVariable Integer id) {
		Person person = personService.findById(id);
		return personMapper.person2personGetDTO(person);
	}

	@GetMapping("/list")
	public List<PersonGetDTO> findAll() {
		return personMapper.listPerson2listGetDTO(personService.findAll());
//		return personService.findAll().stream().map(person -> personMapper.person2personGetDTO(person)).toList();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		personService.delete(id);
	}

}
