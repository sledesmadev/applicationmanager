package com.project.applicationmanager.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.applicationmanager.dto.UserRequest;
import com.project.applicationmanager.model.User;
import com.project.applicationmanager.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
    public Long login(@RequestBody UserRequest registerRequest) {
		return userService.login(registerRequest);
    }
	
	@PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserRequest registerRequest) {
		userService.signup(registerRequest);
        return new ResponseEntity(OK);
    }
	
}
