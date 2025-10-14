package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

   
    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

  
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    
    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

  
    @Override
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setRole(updatedUser.getRole());
            userDao.update(existingUser); 
            return existingUser;
        }
        return null;
    }

    
    @Override
    public boolean deleteUser(Long id) {
        User user = getUserById(id);
        if (user != null) {
            userDao.delete(id);
            return true;
        }
        return false;
    }

	@Override
	public User getUserByName(String name) {
		return  userDao.findByUsername(name);
		
	}
}
