package com.swiftLendFinancial.main.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.swiftLendFinancial.main.model.Employee;

public interface EmployeeService {

	public Employee saveemp(String fieldText,MultipartFile adhar, MultipartFile photo,  MultipartFile pan,
			MultipartFile sign) throws JsonMappingException, JsonProcessingException, IOException, Exception;

	public Iterable<Employee> getallEmployee();

	public Employee getSingleEmp(int employeeId);

	public Employee deleteemp(int employeeId);


	

	

	

}
