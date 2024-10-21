package com.CRUD_Operation.CRUD_Operation.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.CRUD_Operation.CRUD_Operation.model.User;

@Repository
public class FileUserRepository {
	private final String FILE_PATH = "users.txt";

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length == 3) {
					User user = new User();
					user.setId(Long.parseLong(data[0]));
					user.setName(data[1]);
					user.setEmail(data[2]);
					users.add(user);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;

	}

	public User createUser(User user) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			String userData = user.getId() + "," + user.getName() + "," + user.getEmail();
			bw.write(userData);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User updateUser(Long id, User updatedUser) {
		List<User> users = getAllUsers();
		boolean userFound = false;

		// Update user in the list
		for (User user : users) {
			if (user.getId().equals(id)) {
				user.setName(updatedUser.getName());
				user.setEmail(updatedUser.getEmail());
				userFound = true;
				break;
			}
		}

		if (userFound) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
				for (User user : users) {
					String userData = user.getId() + "," + user.getName() + "," + user.getEmail();
					bw.write(userData);
					bw.newLine();
				}
				return updatedUser;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean deleteUser(Long id) {
		List<User> users = getAllUsers();
		boolean userFound = false;

		users.removeIf(user -> user.getId().equals(id));

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (User user : users) {
				String userData = user.getId() + "," + user.getName() + "," + user.getEmail();
				bw.write(userData);
				bw.newLine();
			}
			userFound = true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userFound;
	}

	public User getUserById(Long id) {
		List<User> users = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				User user = new User();
				user.setId(Long.parseLong(data[0]));
				user.setName(data[1]);
				user.setEmail(data[2]);
				users.add(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

}
