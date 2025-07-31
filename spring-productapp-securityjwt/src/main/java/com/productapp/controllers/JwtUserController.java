package com.productapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.JwtUserRequest;
import com.productapp.service.JwtUserServiceImpl;
import com.productapp.util.JwtTokenUtil;

@RestController
@RequestMapping("/user-api/v1")
public class JwtUserController {
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JwtUserServiceImpl userServiceImpl;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	// first time user
	@PostMapping("/register")
	public ResponseEntity<Void> createUser(@RequestBody JwtUserRequest userRequest){
		// get the password and encode it
		String pass = userRequest.getPassword();
		String newpass = encoder.encode(pass);
		userRequest.setPassword(newpass);
		userServiceImpl.createUser(userRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// user logging in and getting the token
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody JwtUserRequest userRequest){
		// get the username
		String username = userRequest.getUsername();
		// check if the name is available in the db
		UserDetails userdetails =  userServiceImpl.loadUserByUsername(username);
		String token = jwtTokenUtil.generateToken(userdetails);
		return ResponseEntity.ok(token);
	}
	
}










