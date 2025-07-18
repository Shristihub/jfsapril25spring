package com.greetapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService{

	@Override
	public List<String> getBooks() {
		return List.of("Java in Action","Leadership");
	}

}
