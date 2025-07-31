package com.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productapp.model.ApiUser;

public interface IApiUserRepository extends JpaRepository<ApiUser, Integer>{
	
//	@Query("from ApiUser au inner join au.roles r where au.username=?")
	 ApiUser findByUsername(String username);
}
