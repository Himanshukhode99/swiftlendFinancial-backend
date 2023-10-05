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
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerFirstName;
	private String customerMiddleName;
	private String customerLastName;
	private String customerMotherName;
	private String noOfDependends;
	private String customerDob;
	private String customerGender;
	private long customerMobileno;
	private String customerGmail;

}
