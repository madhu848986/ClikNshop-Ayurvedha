package com.example.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Session.SessionStore;
import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	  @Autowired
	    private UserService userService;

	    // ===================== REGISTER =====================

	    @PostMapping("/register/customer")
	    public User registerCustomer(@RequestBody User user) {
	        user.setRole("CUSTOMER");
	        return userService.addUser(user);
	    }

	    @PostMapping("/register/shop")
	    public User registerShopOwner(@RequestBody User user) {
	        user.setRole("SHOP_OWNER");
	        return userService.addUser(user);
	    }

	    @PostMapping("/register/admin")
	    public User registerAdmin(@RequestBody User user) {
	        user.setRole("ADMIN");
	        return userService.addUser(user);
	    }

	    // ===================== LOGIN =====================

	    @PostMapping("/login")
	    public String login(@RequestBody User loginRequest) {
	        User user = userService.getUserByName(loginRequest.getName());
	        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
	            String sessionId = UUID.randomUUID().toString();
	            SessionStore.addSession(sessionId, user);
	            return "Login successful. Session ID: " + sessionId + " (Role: " + user.getRole() + ")";
	        }
	        return "Invalid username or password";
	    }

	    // ===================== GET CURRENT USER =====================

	    @GetMapping("/me")
	    public User me(@RequestHeader("sessionId") String sessionId) {
	        if (SessionStore.isValid(sessionId)) {
	            return SessionStore.getUser(sessionId);
	        }
	        return null; // Or throw an exception
	    }

	    // ===================== LOGOUT =====================

	    @PostMapping("/logout")
	    public String logout(@RequestHeader("sessionId") String sessionId) {
	        if (SessionStore.isValid(sessionId)) {
	            SessionStore.removeSession(sessionId);
	            return "Logout successful";
	        }
	        return "Invalid session";
	    }

}
