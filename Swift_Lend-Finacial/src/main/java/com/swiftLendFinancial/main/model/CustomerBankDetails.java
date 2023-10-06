package com.swiftLendFinancial.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CustomerBankDetails
{
	@Id
	private long customerAccountNo;
	private String accountHolderName;
	private String bankName;
	private String branchName;
	private long IFSCCode;
	private String accountType;
	
	

}
