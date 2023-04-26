package com.app.bookstore.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//pt ca o clasa sa fie un Bean (o clasa managed de SpringBoot), trebuie sa punem adnotarea - de exemplu - @Service
//Corect: Un Bean este un OBIECT care este instantiat si manage-uit de SpringBoot (IOC - Inversion of Controler)
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public User update(User userToUpdate, Integer userId) {
		User existingUser = userRepository.findById(userId).orElseThrow();
		existingUser.setFirstName(userToUpdate.getFirstName());
		existingUser.setLastName(userToUpdate.getFirstName());
		existingUser.setAge(userToUpdate.getAge());
		existingUser.setEmail(userToUpdate.getEmail());

		return userRepository.save(existingUser);
	}
}
