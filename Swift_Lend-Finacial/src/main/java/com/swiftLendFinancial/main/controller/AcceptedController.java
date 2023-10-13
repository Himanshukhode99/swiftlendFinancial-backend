package com.swiftLendFinancial.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swiftLendFinancial.main.model.Accepted;
import com.swiftLendFinancial.main.model.Rejected;
import com.swiftLendFinancial.main.service.Accepted_Service;
import com.swiftLendFinancial.main.service.Rejected_Service;
@CrossOrigin("*")
@RestController
public class AcceptedController {
	
	@Autowired
	Accepted_Service as;
	
	
	
	@PostMapping("/saveAccepted")
	public ResponseEntity<Accepted> saveAccepted(@RequestBody Accepted a)
	{
		Accepted at=as.saveAccepted(a);
		
		return new ResponseEntity<Accepted>(at,HttpStatus.OK) ;
	}

	
	@GetMapping("/getApproved")
	public ResponseEntity<Iterable<Accepted>>  getApproved()
	{
		Iterable<Accepted> approved = as.getApproved();
		
		return  new ResponseEntity<Iterable<Accepted>>( approved, HttpStatus.OK);
		
		
	}
	
	
	
	@GetMapping("/getApprovedByEmail/{email}")
	public ResponseEntity<Optional<Accepted>>  getApprovedByEmail(@PathVariable String email)
	{
		Optional<Accepted>  approved = as.getApprovedByEmail(email);
		
		return  new ResponseEntity<Optional<Accepted>>( approved, HttpStatus.OK);
		
		
	}
	
}
