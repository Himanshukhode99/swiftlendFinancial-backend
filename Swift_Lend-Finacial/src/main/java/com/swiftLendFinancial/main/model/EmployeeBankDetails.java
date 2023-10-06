package com.swiftLendFinancial.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EmployeeBankDetails 
{
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private int bankdetailsId;
 private long employeeAccNo;
 private String employeeBankname;
 private String employeeBranchName;
 private long employeeIFSCNo;
 private long employeeBankCode;
 private long employeeCIFNo;
 
  
}