package com.example.autowire;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements IShape{

	@Override
	public void calcArea(int x, int y) {
		System.out.println("Rect "+(x*y));
	}

}
