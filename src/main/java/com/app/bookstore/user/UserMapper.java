package com.app.bookstore.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public User userCreateDTO2User(UserCreateDTO userCreateDTO) {
		User user = new User();
		user.setFirstName(userCreateDTO.getFirstName());
		user.setLastName(userCreateDTO.getLastName());
		user.setAge(userCreateDTO.getAge());
		user.setEmail(userCreateDTO.getEmail());

		return user;
	}

	public UserGetDTO user2UserGetDTO(User user) {
		UserGetDTO userGetDTO = new UserGetDTO();
		userGetDTO.setFirstName(user.getFirstName());
		userGetDTO.setLastName(user.getLastName());
		userGetDTO.setAge(user.getAge());
		userGetDTO.setEmail(user.getEmail());
		
		return userGetDTO;
	}
}
