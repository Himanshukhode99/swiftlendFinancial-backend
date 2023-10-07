package com.swiftLendFinancial.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerBankDetails
{
	@Id
	private long accountNo;
	private String Acholdername;
	private String bankName;
	private String bankBranchName;
	private long bankifsccode;
	private String accounttype; 
	
	

} 
  