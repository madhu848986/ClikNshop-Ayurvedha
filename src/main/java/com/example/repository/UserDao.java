package com.example.repository;

import java.util.List;

import com.example.model.User;

public interface UserDao {
	 User findByUsername(String username);
	    User findByEmail(String email);
	    User findById(Long id);
	    List<User> findAll();
	    User save(User user);
	    void update(User user);
	    void delete(Long id);

}
