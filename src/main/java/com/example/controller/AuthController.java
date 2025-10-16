package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register/customer")
    public ResponseEntity<?> registerCustomer(@RequestBody User user) {
        try {
            System.out.println("Registering customer: " + user.getUsername());
            user.setRole("CUSTOMER");
            User savedUser = userService.addUser(user);
            System.out.println("User registered successfully with ID: " + savedUser.getId());
            
            // Return user without password for security
            savedUser.setPassword(null);
            return ResponseEntity.ok(savedUser);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/register/shop")
    public ResponseEntity<?> registerShopOwner(@RequestBody User user) {
        try {
            System.out.println("Registering shop owner: " + user.getUsername());
            user.setRole("SHOP_OWNER");
            User savedUser = userService.addUser(user);
            savedUser.setPassword(null);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody User user) {
        try {
            System.out.println("Registering admin: " + user.getUsername());
            user.setRole("ADMIN");
            User savedUser = userService.addUser(user);
            savedUser.setPassword(null);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        try {
            System.out.println("Login attempt for: " + loginRequest.getUsername());
            User user = userService.getUserByName(loginRequest.getUsername());
            
            if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
                // Login successful - return user info without password
                user.setPassword(null);
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.status(401).body("Invalid username or password");
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }

   
}