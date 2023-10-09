package com.swiftLendFinancial.main.model;

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
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String employeeName;
	private long mobile;
	private String dob;
	private String email; 
    private String gender;
   
    private String designation;
    @OneToOne(cascade = CascadeType.ALL)
   	public User user;
    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeLocalAddress localAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private EmployeePermanetAddress permenantAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeBankDetails bankDetails;
    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeDocuments documents;
   
    
   
    
}
