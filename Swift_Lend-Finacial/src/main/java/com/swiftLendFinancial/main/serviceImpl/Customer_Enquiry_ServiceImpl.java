package com.swiftLendFinancial.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.swiftLendFinancial.main.exception.EnquiryAlreadyExists;
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
		sm.setText("Hello,"+c.getFirst_name()+" "+c.getLast_name()+"\n Thank you for reaching out and expressing interest in our services"+"\n \n Thanks & Regards \n {SwiftLend Financial}");
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
        
        
        CustomerEnquiry customerenq;
        Optional<CustomerEnquiry> customer=enquiry_Repository.findById(c.getEmail());
        if(customer.isPresent())
        {
        	throw new EnquiryAlreadyExists("Email Was Already Registerd..");
        
        }
        else 
        {
        	customerenq=enquiry_Repository.save(c);
		}
        
		return customerenq;
		

		
		
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
