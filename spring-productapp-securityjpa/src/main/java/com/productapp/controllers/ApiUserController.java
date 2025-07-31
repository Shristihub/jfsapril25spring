package com.productapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.ApiUser;
import com.productapp.model.ApiUserRequest;
import com.productapp.service.ApiUserServiceImpl;

@RestController
@RequestMapping("/user-api/v1")
public class ApiUserController {

	@Autowired
	private ApiUserServiceImpl userServiceImpl;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/apiusers/register")
	public ResponseEntity<Void> createUser(@RequestBody ApiUserRequest userRequest) {
//		get the password and encode the pssword
//		String password = userRequest.getPassword();
//	    String newpassword= passwordEncoder.encode(password); 
//		set it again in userRequest object
//	    userRequest.setPassword(newpassword);
		
		userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		// convert the apiuserrequest to apiuser object
		ApiUser apiuser = mapper.map(userRequest,ApiUser.class);
		//call the method of service to save the apiuser object
		userServiceImpl.createUser(apiuser);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}










