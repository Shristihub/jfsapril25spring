package com.productapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiUserRequest{

	private String username;
	private Integer userId;
	private String password;
	private List<String> roles;

}
