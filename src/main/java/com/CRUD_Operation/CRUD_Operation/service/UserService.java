package com.CRUD_Operation.CRUD_Operation.service;

import java.util.List;

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
		return userRepository.findById(id).orElse(null);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
