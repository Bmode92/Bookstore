package Tema.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person create(Person person) {
		return personRepository.save(person);
	}

	public Person findById(Integer id) {
		return personRepository.findById(id).orElseThrow();
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person update(Person personToUpdate, Integer personId) {
		Person existingPerson = personRepository.findById(personId).orElseThrow();
		existingPerson.setNume(personToUpdate.getNume());
		existingPerson.setPrenume(personToUpdate.getPrenume());
		existingPerson.setVarsta(personToUpdate.getVarsta());

		return personRepository.save(existingPerson);
	}

	public void delete(Integer personId) {
		personRepository.deleteById(personId);
	}

}
