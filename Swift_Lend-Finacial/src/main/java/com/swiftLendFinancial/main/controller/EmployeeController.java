package com.swiftLendFinancial.main.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swiftLendFinancial.main.model.Employee;
import com.swiftLendFinancial.main.service.EmployeeService;

@RestController
@RequestMapping("/Swift_Lend_Financial")
public class EmployeeController 
{
	@Autowired
	EmployeeService es;
	@PostMapping("/saveemp")
	public ResponseEntity<Employee> saveemp(
			@RequestPart("personalDetails")String fieldText,
			@RequestPart("empDoc")String empDoc,
			
			@RequestPart(name="profileImage",required =true)MultipartFile profileimage,
			@RequestPart("adhar")MultipartFile adhar,
			@RequestPart("pan")MultipartFile pan,
			@RequestPart("sign")MultipartFile sign) throws Exception, JsonProcessingException, IOException 
	{
		
		Employee emp=es.saveemp(fieldText,profileimage,adhar,pan,sign,empDoc);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	@GetMapping("/getallemp")
	public ResponseEntity<Iterable<Employee>> getAllEmployee()
	{
		Iterable<Employee> employee=es.getallEmployee();
		return new ResponseEntity<Iterable<Employee>>(employee,HttpStatus.OK);
	}

}
