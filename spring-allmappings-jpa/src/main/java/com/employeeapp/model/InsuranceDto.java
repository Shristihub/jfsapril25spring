package com.employeeapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsuranceDto {
	private String insuranceName;
	private Integer insuranceId;
	private String brand;
	private String type; //health,education.vehicle,house
	private double premium;
	
	

}
