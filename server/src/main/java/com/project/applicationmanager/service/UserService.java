package com.project.applicationmanager.service;

import java.util.Optional;

import com.project.applicationmanager.dto.UserDTO;
import com.project.applicationmanager.dto.UserRequest;
import com.project.applicationmanager.model.User;

public interface UserService {

	public Optional<User> findByUsername(String username);
	public Long login (UserRequest loginRequest);
	public void signup(UserRequest signUp);
	
}
