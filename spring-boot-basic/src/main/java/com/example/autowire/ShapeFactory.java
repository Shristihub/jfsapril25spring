package com.example.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	@Autowired
	@Qualifier("rectangle")  // autowiring by type
	private IShape shape; // shape = new Rectangle();
	
	// By name - bean name and instance variable name should be same
	@Autowired
	private IShape square;
	
	private IShape nshape;
		
	public ShapeFactory(@Qualifier("triangle") IShape nshape) {
		super();
		this.nshape = nshape;
	}


	public void printArea(int x, int y) {
		System.out.println("Printing Area");
		shape.calcArea(x, y);
		square.calcArea(x, y);
		nshape.calcArea(x, y);
	}
}
