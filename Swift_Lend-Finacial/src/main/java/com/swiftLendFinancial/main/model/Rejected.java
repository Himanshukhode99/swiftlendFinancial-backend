package com.swiftLendFinancial.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor 
public class Rejected  {
	
	
	private String first_name;
	private String middle_name;
	private String last_name;
	@Id
	private String email;
	private int age;
	private long mobile;
	private String address;
	private String pan;
	private long loanamount;
	private int cibilscore; 
	private String cibilstatus;
	
	
	

}
