package com.swiftLendFinancial.main.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer
{

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String mother_name;
	private int noOfdependent;
	private Date dob;
	private String gender;
	private long mobile;
	
	@Id
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	public User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerLocalAddress localAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerPermanentAddress permenantAddress;
	@OneToOne (cascade = CascadeType.ALL)
	private CustomerBankDetails bankDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocuments documents;
	 


}
