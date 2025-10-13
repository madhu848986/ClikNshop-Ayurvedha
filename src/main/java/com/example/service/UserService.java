package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	  User addUser(User user);

	    List<User> getAllUsers();

	    User getUserById(Long id);

	    User updateUser(Long id, User updatedUser);

	    boolean deleteUser(Long id);

		User getUserByName(String name);
}
