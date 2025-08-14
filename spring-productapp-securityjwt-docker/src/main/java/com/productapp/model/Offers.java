package com.productapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Offers {
	@Id
	@GeneratedValue(generator = "offers_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "offers_gen",sequenceName = "offers_seq", initialValue = 51,allocationSize = 1)
	private Integer offerId;
	private String offerType; //No cost emi,cashback,bank offer
	private String description;
	

}
