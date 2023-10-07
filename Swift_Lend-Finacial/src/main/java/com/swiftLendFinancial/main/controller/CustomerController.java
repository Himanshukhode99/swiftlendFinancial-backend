package com.swiftLendFinancial.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import com.swiftLendFinancial.main.model.Customer;
import com.swiftLendFinancial.main.model.User;
import com.swiftLendFinancial.main.service.CustomerService;
@CrossOrigin("*")
@RestController
@RequestMapping("/Swift_Lend_Financial")
public class CustomerController 
{
	@Autowired
	CustomerService cs;
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(
			@RequestPart("personaldetails")String fieldText,
			@RequestPart("user")String user,
			@RequestPart("documentsUpload")String customerdoc,
			@RequestPart("aadharcard")MultipartFile adhar,
			@RequestPart("pancard")MultipartFile pan,
			@RequestPart("profile_photo")MultipartFile photo,
			@RequestPart("signature")MultipartFile sign,
			@RequestPart("salary_slip")MultipartFile salaryslip,
			@RequestPart("driving_license")MultipartFile drivingLiecense,    
			@RequestPart("bank_statement")MultipartFile bankstatement,
			@RequestPart("car_quatation")MultipartFile carquatation,
			@RequestPart("form16")MultipartFile form16,  
			@RequestPart("income_tax_return")MultipartFile incometaxreturn
			 
			) throws Exception
	{
		Customer customer=cs.saveCustomer(fieldText ,user,customerdoc,adhar,pan,photo,sign,salaryslip,drivingLiecense,bankstatement,incometaxreturn, carquatation,form16);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}  
	@GetMapping("/getallcustomer")
	public ResponseEntity<Iterable<Customer>> getallCustomer()
	{
		Iterable<Customer> list=cs.getallCustomer();
		return new ResponseEntity<Iterable<Customer>>(list,HttpStatus.OK); 
	}

}
