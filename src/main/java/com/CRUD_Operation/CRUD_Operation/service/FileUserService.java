package com.CRUD_Operation.CRUD_Operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD_Operation.CRUD_Operation.model.User;
import com.CRUD_Operation.CRUD_Operation.repository.FileUserRepository;

@Service
public class FileUserService {
	@Autowired
	private FileUserRepository fileUserRepository;

	public List<User> getAllUsers() {
		return fileUserRepository.getAllUsers();
	}

	public User createUser(User user) {
		return fileUserRepository.createUser(user);
	}

	public User updateUser(Long id, User user) {
		return fileUserRepository.updateUser(id, user);
	}

	public boolean deleteUser(Long id) {
		return fileUserRepository.deleteUser(id);
	}

	public User getUserById(Long id) {
		return fileUserRepository.getUserById(id);
	}
}
