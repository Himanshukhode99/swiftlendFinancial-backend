package com.swiftLendFinancial.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiftLendFinancial.main.model.User;
import com.swiftLendFinancial.main.repository.UserRepository;
import com.swiftLendFinancial.main.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserRepository ur;
	
	@Override
	public Iterable<User> getAllUser() {
		
		return ur.findAll();
	}

}
