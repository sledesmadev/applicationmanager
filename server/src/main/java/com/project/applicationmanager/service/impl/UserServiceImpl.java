package com.project.applicationmanager.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.applicationmanager.dto.UserDTO;
import com.project.applicationmanager.dto.UserRequest;
import com.project.applicationmanager.exception.ApplicationManagerException;
import com.project.applicationmanager.model.User;
import com.project.applicationmanager.repository.UserRepository;
import com.project.applicationmanager.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Long login(UserRequest loginRequest) throws ApplicationManagerException{
		
		Long id = userRepository.findByUserPassword(loginRequest.getUsername(), loginRequest.getPassword()).orElseThrow(() -> new ApplicationManagerException(
                "Login incorrect" ));
		
		return id;
	}

	@Override
	public void signup(UserRequest signUp) {
		User newUser = new User();
		newUser.setUsername(signUp.getUsername());
		newUser.setPassword(signUp.getPassword());
		userRepository.save(newUser);
	}

}
