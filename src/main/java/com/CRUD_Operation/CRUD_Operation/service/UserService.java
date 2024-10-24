package com.CRUD_Operation.CRUD_Operation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD_Operation.CRUD_Operation.model.User;
import com.CRUD_Operation.CRUD_Operation.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User updatedUser) {
		Optional<User> existingUserOpt = userRepository.findById(id);

		if (existingUserOpt.isPresent()) {
			User existingUser = existingUserOpt.get();
			existingUser.setName(updatedUser.getName());
			existingUser.setEmail(updatedUser.getEmail());
			return userRepository.save(existingUser);
		}
		return null;
	}

	public boolean deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
