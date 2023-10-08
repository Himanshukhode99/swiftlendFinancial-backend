package com.swiftLendFinancial.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerLocalAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int localAddressId;
	private int house_number;
	private String landmark;
	private String street_name;
	private String city_name;
	private String taluka;
	private String district;
	private String state;
	private String country;
	private int pin_code;
	
	

}
