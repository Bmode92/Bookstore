package com.app.bookstore.person.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.bookstore.person.Person;
import com.app.bookstore.person.dto.PersonCreateDTO;
import com.app.bookstore.person.dto.PersonGetDTO;

@Component
public class PersonMapper {

	public Person personCreateDTO2Person(PersonCreateDTO personCreateDTO) {
		Person person = new Person();
		person.setNume(personCreateDTO.getNume());
		person.setPrenume(personCreateDTO.getPrenume());
		person.setVarsta(personCreateDTO.getVarsta());

		return person;
	}

	public PersonGetDTO person2personGetDTO(Person person) {
		PersonGetDTO personGetDTO = new PersonGetDTO();
		personGetDTO.setId(person.getId());
		personGetDTO.setNume(person.getNume());
		personGetDTO.setPrenume(person.getPrenume());
		personGetDTO.setVarsta(person.getVarsta());

		return personGetDTO;
	}

	public List<PersonGetDTO> listPerson2listGetDTO(List<Person> persons) {
		return persons.stream().map(person -> person2personGetDTO(person)).toList();
	}
	
}