package com.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.productapp.model.ApiUser;
import com.productapp.repository.IApiUserRepository;

@Service
public class ApiUserServiceImpl implements UserDetailsManager{

	@Autowired
	private IApiUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApiUser apiuser =   userRepository.findByUsername(username);
		if(apiuser==null)
			throw new UsernameNotFoundException("invalid username");
		
		// interface ref = implementation class
		UserDetails userDetails =  apiuser;
		return userDetails;
		
		
	}

	@Override
	public void createUser(UserDetails user) {
		ApiUser apiuser = (ApiUser)user;
		userRepository.save(apiuser);
	}

	@Override
	public void updateUser(UserDetails user) {
		userRepository.save((ApiUser)user);		
	}

	@Override
	public void deleteUser(String username) {
		ApiUser user = userRepository.findByUsername(username);
		userRepository.delete(user);
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
