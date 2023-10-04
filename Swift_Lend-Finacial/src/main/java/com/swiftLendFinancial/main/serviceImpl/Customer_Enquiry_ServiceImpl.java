package com.swiftLendFinancial.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiftLendFinancial.main.model.CustomerEnquiry;
import com.swiftLendFinancial.main.repository.Customer_Enquiry_Repository;
import com.swiftLendFinancial.main.service.Customer_Enquiry_Service;

@Service
public class Customer_Enquiry_ServiceImpl implements Customer_Enquiry_Service {
	
	@Autowired
	Customer_Enquiry_Repository enquiry_Repository;

	@Override
	public CustomerEnquiry save(CustomerEnquiry c) {

		
		if(c.getCibil()>750) {
		enquiry_Repository.save(c);
		return c; 
		}
		return null;
		
	}

	@Override
	public List<CustomerEnquiry> getEnquiries() {
		
		return enquiry_Repository.findAll();
	}

	@Override
	public CustomerEnquiry getEnquiriesByMail(String email) {
		
		return enquiry_Repository.findByEmail(email); 
	}

}
