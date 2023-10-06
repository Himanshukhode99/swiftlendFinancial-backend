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
public class EmployeeLocalAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	private String areaName;
	private String cityName;
	private String districtName;
	private String landMark;
	private String stateName;
	private int pincode;

}
