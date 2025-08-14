package com.productapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.productapp.model.JwtUser;
import com.productapp.repository.IJwtUserRepository;

@Service
public class JwtUserServiceImpl implements UserDetailsManager{

	@Autowired
	private IJwtUserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUser jwtuser = userRepository.findByUsername(username);
		if(jwtuser==null)
			throw new UsernameNotFoundException("invalid name");
		UserDetails userDetails= new User(username, jwtuser.getPassword(), jwtuser.getAuthorities());
		return userDetails;
	}

	@Override
	public void createUser(UserDetails userRequest) {
		//convert userrequest to jwtuser
		JwtUser jwtuser =  mapper.map(userRequest, JwtUser.class);
		userRepository.save(jwtuser);
		
	}

	@Override
	public void updateUser(UserDetails userRequest) {
		//convert userrequest to jwtuser
		JwtUser jwtuser =  mapper.map(userRequest, JwtUser.class);
		userRepository.save(jwtuser);
	}

	@Override
	public void deleteUser(String username) {
		JwtUser user = userRepository.findByUsername(username);
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
