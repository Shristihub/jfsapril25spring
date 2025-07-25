package com.productapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiErrors {
	
	private LocalDateTime timestamp;
	private int statusCode;
	private String errorMessage;
	private HttpStatus status;

	
}
