package com.swiftLendFinancial.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CustomerPermanentAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int localAddressId;
	private String HouseNo;
	private String landMark;
	private String streetName;
	private String cityName;
	private String taluka;
	private String district;
	private String state;
	private String country;
	private int pincode;

}
