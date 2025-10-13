package com.example.repository;

import java.util.List;

import com.example.model.User;

public interface UserDao {
	int save(User user);
    List<User> findAll();

}
