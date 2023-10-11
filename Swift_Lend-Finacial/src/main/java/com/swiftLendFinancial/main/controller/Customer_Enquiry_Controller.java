package com.swiftLendFinancial.main.controller;

import java.util.List;

import javax.transaction.Transactional;

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
import org.springframework.web.bind.annotation.RestController;

import com.swiftLendFinancial.main.model.CustomerEnquiry;
import com.swiftLendFinancial.main.service.Customer_Enquiry_Service;




@CrossOrigin("*")
@Transactional
@RestController
@RequestMapping("/Swift_Lend_Financial")
public class Customer_Enquiry_Controller {
	
	@Autowired
	Customer_Enquiry_Service enquiry_Service;
	
	
	@PostMapping("/saveEnquiry")
	public ResponseEntity<CustomerEnquiry> save(@RequestBody CustomerEnquiry c)
	{
		
		CustomerEnquiry ce=enquiry_Service.save(c);
		
		return new ResponseEntity<CustomerEnquiry>(ce, HttpStatus.OK);
	}
	
	@GetMapping("/getEnquiries")
	public ResponseEntity<List<CustomerEnquiry>> getEnquiries()
	{
		
		List<CustomerEnquiry> list =enquiry_Service.getEnquiries();
		
		return new ResponseEntity<List<CustomerEnquiry>>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/getEnquiriesByMail/{email}")
	public ResponseEntity<CustomerEnquiry> getEnquiriesByMail(@PathVariable String email)
	{
		
		CustomerEnquiry customer =enquiry_Service.getEnquiriesByMail(email);
		
		return new ResponseEntity<CustomerEnquiry>(customer, HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteCustomerEnquiry/{email}")
	public String deleteCustomerEnquiry(@PathVariable String email)
<<<<<<< HEAD
=======

>>>>>>> stash
	{
		enquiry_Service.deleteCustomerEnquiry(email);
		return "dalated data";
	}
	
	@PutMapping("/updateCustomerEnquiry")
	public ResponseEntity<CustomerEnquiry> updateCustomerEnquiry(@RequestBody CustomerEnquiry customer_enquiry)
	{
		CustomerEnquiry ce=enquiry_Service.save(customer_enquiry);
		return new ResponseEntity<CustomerEnquiry>(ce,HttpStatus.OK);
	}

}
