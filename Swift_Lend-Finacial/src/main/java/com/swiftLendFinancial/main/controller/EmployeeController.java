package com.swiftLendFinancial.main.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/Swift_Lend_Financial")
public class EmployeeController 
{
	@Autowired
	EmployeeService es;
	@PostMapping("/saveemp")
	public ResponseEntity<Employee> saveemp(
			@RequestPart("personaldetails")String fieldText,
			@RequestPart("aadharcard")MultipartFile adhar,
			@RequestPart("pancard")MultipartFile pan,
			@RequestPart("profile_photo")MultipartFile photo,
			@RequestPart("signature")MultipartFile sign) throws Exception, JsonProcessingException, IOException 
	{
		
		Employee emp=es.saveemp(fieldText,adhar,pan, photo, sign);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	@GetMapping("/getallemp")
	public ResponseEntity<Iterable<Employee>> getAllEmployee()
	{
		Iterable<Employee> employee=es.getallEmployee();
		return new ResponseEntity<Iterable<Employee>>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getsingleemp/{employeeId}") 
	public ResponseEntity<Employee> getSingleEmp(@PathVariable int employeeId){
		Employee e = es.getSingleEmp(employeeId);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteemp/{employeeId}")
	
	public ResponseEntity<Employee> deleteemp(@PathVariable int employeeId){
		Employee e = es.deleteemp(employeeId);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateemp")
	public ResponseEntity<Employee> updateEmployee(
			@RequestPart("personaldetails")String fieldText,
			@RequestPart("aadharcard")MultipartFile adhar,
			@RequestPart("pancard")MultipartFile pan,
			@RequestPart("profile_photo")MultipartFile photo,
			@RequestPart("signature")MultipartFile sign) throws Exception, JsonProcessingException, IOException 
	{
		
		Employee emp1=es.saveemp(fieldText,adhar,pan, photo, sign);
		return new ResponseEntity<Employee>(emp1,HttpStatus.OK);
		
	}
	

}
