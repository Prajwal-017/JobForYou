package com.example.jobforyou.service;

import com.example.jobforyou.Entity.User;

public interface UserService {

	void registerUser(User user);

	User verifyCredentials(String email, String password);

	boolean changePassword(String email, String newPassword);

}
