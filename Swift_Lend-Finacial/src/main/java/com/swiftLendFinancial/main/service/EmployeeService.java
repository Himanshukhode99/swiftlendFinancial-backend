package com.swiftLendFinancial.main.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.swiftLendFinancial.main.model.Employee;

public interface EmployeeService {

	public Employee saveemp(String fieldText, MultipartFile profileimage, MultipartFile adhar, MultipartFile pan,
			MultipartFile sign, String empDoc) throws JsonMappingException, JsonProcessingException, IOException, Exception;

	public Iterable<Employee> getallEmployee();


	

	

	

}
