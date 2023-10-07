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
			@RequestPart("customerdoc")String customerdoc,
			@RequestPart("adhar")MultipartFile adhar,
			@RequestPart("pan")MultipartFile pan,
			@RequestPart("profilephoto")MultipartFile photo,
			@RequestPart("sign")MultipartFile sign,
			@RequestPart("salaryslip")MultipartFile salaryslip,
			@RequestPart("drivingLiecense")MultipartFile drivingLiecense,
			@RequestPart("bankstatement")MultipartFile bankstatement,
			@RequestPart("carquqtation")MultipartFile carquatation,
			@RequestPart("form16")MultipartFile form16,
			@RequestPart("incometaxreturn")MultipartFile incometaxreturn
			
			) throws Exception
	{
		Customer customer=cs.saveCustomer(fieldText,customerdoc,adhar,pan,photo,sign,salaryslip,drivingLiecense,bankstatement,incometaxreturn, carquatation,form16,user);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}
	@GetMapping("/getallcustomer")
	public ResponseEntity<Iterable<Customer>> getallCustomer()
	{
		Iterable<Customer> list=cs.getallCustomer();
		return new ResponseEntity<Iterable<Customer>>(list,HttpStatus.OK);
	}

}
