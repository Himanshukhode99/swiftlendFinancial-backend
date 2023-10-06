package com.swiftLendFinancial.main.serviceImpl;

import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swiftLendFinancial.main.model.Employee;
import com.swiftLendFinancial.main.model.EmployeeDocuments;
import com.swiftLendFinancial.main.repository.EmployeeRepository;
import com.swiftLendFinancial.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Value("${spring.mail.username}")
	private String fromMail;

	@Autowired
	EmployeeRepository er;

	@Autowired
	JavaMailSender jms;

	Random ran = new Random();

	int ul = 100000;
	int ll = 1000;

	@Override
	public Employee saveemp(String fieldText, MultipartFile profileimage, MultipartFile adhar, MultipartFile pan,
			MultipartFile sign, String empdoc) throws Exception {

		ObjectMapper obj = new ObjectMapper();
		Employee e;

		EmployeeDocuments ed = obj.readValue(empdoc, EmployeeDocuments.class);

		ed.setProfilePhoto(profileimage.getBytes());

		ed.setAadharCard(adhar.getBytes());

		ed.setPanCard(pan.getBytes());

		ed.setSign(sign.getBytes());

		e = obj.readValue(fieldText, Employee.class);

		e.setEmployeeDocument(ed);

		int pass = ran.nextInt(ul-ll);

		e.user.setPassword(pass);

		//System.out.println(e.getPassword());

		e.user.setUsername(e.getEmployeeEmail());

		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom(fromMail);
		sm.setTo(e.getEmployeeEmail());
		sm.setSubject("your username and password");
		sm.setText("UserName:" + e.getEmployeeEmail() + " Password:" + e.user.getPassword());
		jms.send(sm);
		er.save(e);
		return e;
	}

	@Override
	public Iterable<Employee> getallEmployee() {

		return er.findAll();
	}

}
