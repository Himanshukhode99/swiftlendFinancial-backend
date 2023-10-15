package com.swiftLendFinancial.main.exception;

public class EmployeeAlreadyExists extends RuntimeException 
{
	public EmployeeAlreadyExists(String ExceptionMessage)
	{
		super(ExceptionMessage);
	}
	

}
