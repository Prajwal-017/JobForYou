package com.example.jobforyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobforyou.Entity.User;
import com.example.jobforyou.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        // Save the user directly to the repository without encoding the password
        userRepository.save(user);
    }

    @Override
    public User verifyCredentials(String email, String password) {
        // Find the user by email
        User user = userRepository.findByEmail(email);

        // Check if the user exists and if the password matches exactly
        if (user != null && password.equals(user.getPassword())) {
            // Password matches, return the user
            return user;
        }

        // Invalid credentials, return null
        return null;
    }

    @Override
    public boolean changePassword(String email, String newPassword) {
        // Find the user by email
        User user = userRepository.findByEmail(email);

        // Check if the user was found
        if (user != null) {
            // Update the user's password
            user.setPassword(newPassword);
            
            // Save the updated user
            userRepository.save(user);
            
            // Return true indicating the password change was successful
            return true;
        }
        
        // If the user was not found, return false indicating the password change failed
        return false;
    }

}
