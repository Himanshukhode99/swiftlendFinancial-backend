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
import com.swiftLendFinancial.main.model.User;
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
	public Customer saveCustomer(String fieldText, MultipartFile adhar, MultipartFile pan, MultipartFile photo, MultipartFile sign, MultipartFile salaryslip, MultipartFile drivingLiecense, MultipartFile bankstatement, MultipartFile carquatation, MultipartFile form16, MultipartFile incometaxreturn ) throws Exception
	{
		
		
		
		
	
		ObjectMapper obj = new ObjectMapper();
		Customer customer;
		customer=obj.readValue(fieldText, Customer.class);
		
		
		
		 
		CustomerDocuments cd=new CustomerDocuments();
		
		
		byte[] aaddhar  = obj.readValue(adhar.getBytes(), byte[].class);
		byte[] pann = obj.readValue(pan.getBytes(), byte[].class);
		byte[] profilepp = obj.readValue(photo.getBytes(), byte[].class);
		byte[] signn = obj.readValue(sign.getBytes(), byte[].class);
		byte[] sala = obj.readValue(salaryslip.getBytes(), byte[].class);
		byte[] dl = obj.readValue(drivingLiecense.getBytes(), byte[].class);
		byte[] bs = obj.readValue(bankstatement.getBytes(), byte[].class);
		byte[] cq = obj.readValue(carquatation.getBytes(), byte[].class);
		byte[] f16 = obj.readValue(form16.getBytes(), byte[].class);
		byte[] itr = obj.readValue(incometaxreturn.getBytes(), byte[].class);
		
		cd.setAadharcard(aaddhar);
		cd.setPancard(pann);
		cd.setProfile_photo(profilepp);
		cd.setSignature(signn);
		cd.setSalary_slip(sala);
		cd.setDriving_license(dl);
		cd.setBank_statement(bs);
		cd.setAadharcard(cq);
		cd.setForm16(f16);
		cd.setIncome_tax_return(itr);
		
		System.out.println(customer.getDocuments().getAadharcard());
		
		customer.setDocuments(cd); 
		User use=new User();
		
		int pass = ran.nextInt(ul-ll);
		use.setPassword(pass);
		use.setUsername(customer.getEmail());
	customer.setUser(use);
		System.out.println(customer);
//		cr.save(customer);
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom(fromMail);
		sm.setTo(customer.getEmail());
		sm.setSubject("your username and password");
		sm.setText("UserName:" + customer.getEmail() + " Password:" + customer.user.getPassword());
		
		jms.send(sm);
		
		return customer;
		
		
	}

	@Override
	public Iterable<Customer> getallCustomer() {
		
		return cr.findAll();
	}

}
