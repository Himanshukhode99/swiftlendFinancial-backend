package com.swiftLendFinancial.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiftLendFinancial.main.model.User;
import com.swiftLendFinancial.main.service.UserService;

@RestController

public class UserController 
{
	@Autowired
	UserService us;
	@PostMapping("/getuser")
	public ResponseEntity<Iterable<User>> getAllUser()
	{
		Iterable<User> user=us.getAllUser();
		return new ResponseEntity<Iterable<User>>(user,HttpStatus.OK);
	}

}
