package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {

	 User createUser(User user);
	 List<User> getAllUsers();
}
