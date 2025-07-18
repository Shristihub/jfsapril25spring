package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OffersDto {
	private Integer offerId;
	private String offerType; //No cost emi,cashback,bank offer
	private String description;
	

}
