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
	private long employeeMobileNumber;
	private String employeeDob;
	private String employeeEmail; 
    private String employeegender;
	private String username;
	private int password;
    private String employeeRole;
    
    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeDocuments employeeDocument;
    //@OneToOne(cascade = CascadeType.ALL)
    //private EmployeeBankDetails employeeBankDetails;
    //@OneToOne(cascade = CascadeType.ALL)
    //private PermanetAddress employeepermanetaddr;
    //@OneToOne(cascade = CascadeType.ALL)
    //private LocalAddress employeeelocaladdr;
    
}
