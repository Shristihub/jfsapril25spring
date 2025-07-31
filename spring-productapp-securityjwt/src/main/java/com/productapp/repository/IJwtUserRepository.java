package com.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productapp.model.JwtUser;

public interface IJwtUserRepository extends JpaRepository<JwtUser, Integer>{
	
	@Query("from JwtUser au inner join au.roles r where au.username=?1")
	 JwtUser findByUsername(String username);
}
