package com.swiftLendFinancial.main.serviceImpl;

import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.swiftLendFinancial.main.model.Customer;
import com.swiftLendFinancial.main.model.CustomerDocuments;
import com.swiftLendFinancial.main.repository.CustomerRepository;
import com.swiftLendFinancial.main.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	JavaMailSender jms;

	@Autowired
	CustomerRepository cr;

	Random ran = new Random();

	int ul = 100000;
	int ll = 1000;
	
	@Override
	public Customer saveCustomer(String fieldText, String customerdoc, MultipartFile adhar, MultipartFile pan,
			MultipartFile photo, MultipartFile sign, MultipartFile salaryslip, MultipartFile drivingLiecense,
			MultipartFile bankstatement, MultipartFile incometaxreturn, MultipartFile carquatation,
			MultipartFile form16) throws IOException 
	{
		ObjectMapper obj = new ObjectMapper();
		Customer customer;
		customer=obj.readValue(fieldText, Customer.class);
		if(customerdoc!=null)
		{
		CustomerDocuments cd=obj.readValue(customerdoc,CustomerDocuments.class);
		cd.setAadharCard(adhar.getBytes());
		cd.setPanCard(pan.getBytes());
		cd.setProfilePhoto(photo.getBytes());
		cd.setSignature(sign.getBytes());
		cd.setSalarySlip(salaryslip.getBytes());
		cd.setDrivingLicense(drivingLiecense.getBytes());
		cd.setBankStatement(bankstatement.getBytes());
		cd.setCarQuatation(carquatation.getBytes());
		cd.setForm16(form16.getBytes());
		cd.setIncomeTaxReturn(incometaxreturn.getBytes());
		
		customer.setDocuments(cd);
		}
		
		int pass = ran.nextInt(ul-ll);
		customer.user.setPassword(pass);
		customer.user.setUsername(customer.getCustomerEmail());
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom(fromMail);
		sm.setTo(customer.getCustomerEmail());
		sm.setSubject("your username and password");
		sm.setText("UserName:" + customer.getCustomerEmail() + " Password:" + customer.user.getPassword());
		jms.send(sm);
		cr.save(customer);
		return customer;
		
		
	}

	@Override
	public Iterable<Customer> getallCustomer() {
		
		return cr.findAll();
	}

}
