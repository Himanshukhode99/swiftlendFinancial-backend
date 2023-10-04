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
public class CustomerEnquiry  {
	
	
	private String name;
	@Id
	private String email;
	private int age;
	private long mob;
	private String address;
	private String pan;
	private int cibil;
	
	

}
