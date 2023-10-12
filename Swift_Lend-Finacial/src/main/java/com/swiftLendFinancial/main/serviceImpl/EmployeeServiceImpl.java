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
import com.swiftLendFinancial.main.model.User;
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
			MultipartFile sign) throws Exception {

		ObjectMapper obj = new ObjectMapper();
		Employee e;

		e = obj.readValue(fieldText, Employee.class);
		EmployeeDocuments ed = new EmployeeDocuments();

		ed.setProfile_photo(profileimage.getBytes());

		ed.setAadharcard(adhar.getBytes());

		ed.setPancard(pan.getBytes());

		ed.setSignature(sign.getBytes());

	

		e.setDocuments(ed);

		int pass = ran.nextInt(ul - ll);

		User u = new User();
		u.setPassword(pass);

		// System.out.println(e.getPassword());

		u.setUsername(e.getEmail());
		e.setUser(u);
		er.save(e);
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom(fromMail);
		sm.setTo(e.getEmail());
		sm.setSubject("your username and password");
		sm.setText("UserName:" + e.getEmail() + " Password:" + e.user.getPassword());
		jms.send(sm);

		return e;
	}

	@Override
	public Iterable<Employee> getallEmployee() {

		return er.findAll();
	}

	@Override
	public Employee getSingleEmp(int employeeId) {
		Employee e = er.findById(employeeId);
		
		return e;
	}

	@Override
	public Employee deleteemp(int employeeId) {
		Employee e1=er.deleteById(employeeId);
		return e1;
	}

}
