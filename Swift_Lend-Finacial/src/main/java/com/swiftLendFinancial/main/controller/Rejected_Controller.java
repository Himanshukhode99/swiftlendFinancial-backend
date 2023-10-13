package com.swiftLendFinancial.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiftLendFinancial.main.model.Employee;
import com.swiftLendFinancial.main.model.Rejected;
import com.swiftLendFinancial.main.service.Rejected_Service;
@CrossOrigin("*")
@RestController
@RequestMapping("/Swift_Lend_Financial")
public class Rejected_Controller {
	
	@Autowired
	Rejected_Service rs;
	
	
	
	@PostMapping("/saveRejected")
	public ResponseEntity<Rejected> saveRejected(@RequestBody Rejected r)
	{
		Rejected rj=rs.saveRejected(r);
		
		return new ResponseEntity<Rejected>(rj,HttpStatus.OK) ;
	}

	@GetMapping("/getallrejected")
	public ResponseEntity<Iterable<Rejected>> getAllRejected()
	{
		
		Iterable<Rejected> rejected=rs.getallRejected();
		return new ResponseEntity<Iterable<Rejected>>(rejected,HttpStatus.OK);
	
	}
}
