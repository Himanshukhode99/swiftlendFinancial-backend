package com.swiftLendFinancial.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
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
	private String customerEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	public User user;
	
	//@OneToOne
	//private CustomerLocalAddress localAddress;
	//@OneToOne
	//private CustomerPermanentAddress permanentAddress;
	//@OneToOne
	//private CustomerBankDetails bankDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocuments documents;
	

}
