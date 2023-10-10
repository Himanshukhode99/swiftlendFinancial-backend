package com.swiftLendFinancial.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.swiftLendFinancial.main.model.CustomerEnquiry;
import com.swiftLendFinancial.main.repository.Customer_Enquiry_Repository;
import com.swiftLendFinancial.main.service.Customer_Enquiry_Service;

@Service
public class Customer_Enquiry_ServiceImpl implements Customer_Enquiry_Service {
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	Customer_Enquiry_Repository enquiry_Repository;

	@Autowired
	JavaMailSender jms;
	
	@Override
	public CustomerEnquiry save(CustomerEnquiry c) 
	{
        if(c.getCibilscore()==0)
        {
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setFrom(fromMail);
		sm.setTo(c.getEmail());
		sm.setSubject("Enquiry Feedback");
		sm.setText("Thank You For Visiting Us");
		jms.send(sm);
        }
        
        
        if(c.getCibilscore()!=0)
        {
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setFrom(fromMail);
		sm.setTo(c.getEmail());
		sm.setSubject("Approved For loan");
		sm.setText("Now You Can Fill The Loan Applicattion Form");
		jms.send(sm);
        }
        
        
        
        
        
        
        
        
		return enquiry_Repository.save(c);
		

		
		
	}

	@Override
	public List<CustomerEnquiry> getEnquiries() {
		
		return enquiry_Repository.findAll();
	}

	@Override
	public CustomerEnquiry getEnquiriesByMail(String email) {
		
		return enquiry_Repository.findByEmail(email); 
	}

	@Override
	public void deleteCustomerEnquiry(String email) {
	
		enquiry_Repository.deleteById(email);
		return;
	}

}
