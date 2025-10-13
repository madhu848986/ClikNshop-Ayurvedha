package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	    User addUser(User user);              
	    User getUserByName(String name);       
	    User getUserById(Long id);
	    List<User> getAllUsers();
	    User updateUser(Long id, User updatedUser);
	    boolean deleteUser(Long id);
}
