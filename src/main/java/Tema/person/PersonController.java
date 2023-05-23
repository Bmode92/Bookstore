package Tema.person;

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

import Tema.car.Car;
import Tema.car.CarService;
import Tema.car.dto.CarCreateDTO;
import Tema.car.dto.CarGetDTO;
import Tema.car.mapper.CarMapper;
import Tema.person.dto.PersonCreateDTO;
import Tema.person.dto.PersonGetDTO;
import Tema.person.mapper.PersonMapper;

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

	@GetMapping()
	public List<PersonGetDTO> findAll() {
		return personService.findAll().stream().map(person -> personMapper.person2personGetDTO(person)).toList();
	}

	@PutMapping("/{id}")
	public PersonGetDTO update(@RequestBody PersonCreateDTO personCreateDTO, @PathVariable Integer id) {
		Person person = personMapper.personCreateDTO2Person(personCreateDTO);
		Person updatedPerson = personService.update(person, id);

		return personMapper.person2personGetDTO(updatedPerson);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		personService.delete(id);
	}

}
