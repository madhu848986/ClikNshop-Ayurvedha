package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.User;
import com.example.repository.UserDao;

public class UserServiceImpl implements UserService {

	 @Autowired
	    private UserDao userDao;

	    @Override
	    public User createUser(User user) {
	        userDao.save(user);
	        return user;
	    }

	    @Override
	    public List<User> getAllUsers() {
	        return userDao.findAll();
	    }
}
