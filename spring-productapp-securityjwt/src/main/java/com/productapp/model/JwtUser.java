package com.productapp.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class JwtUser implements UserDetails {

	@Column(unique = true)
	private String username;
	@Id
	@GeneratedValue
	private Integer userId;
	private String password;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="jwtuser_roles")
	private List<String> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities =  new ArrayList<>();
//		//iterate thru the roles
//		for (String role : roles) {
//			//create a Simple GrantedAutority object
//			GrantedAuthority authority =  new SimpleGrantedAuthority(role);
//			authorities.add(authority);
//		}
//		return authorities;
		
		//using streams
		//convert roles to stream
		List<SimpleGrantedAuthority> authorities = 
			  roles.stream()
		      //convert each role to GA object
		      .map(role-> new SimpleGrantedAuthority(role))
		      .toList();
		
		return authorities;
		
		}
}
