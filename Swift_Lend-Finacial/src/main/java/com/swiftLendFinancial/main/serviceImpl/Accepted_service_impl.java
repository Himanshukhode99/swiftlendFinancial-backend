package com.swiftLendFinancial.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.swiftLendFinancial.main.model.Accepted;
import com.swiftLendFinancial.main.model.Rejected;
import com.swiftLendFinancial.main.repository.Accepted_Repository;
import com.swiftLendFinancial.main.repository.Rejected_Repository;
import com.swiftLendFinancial.main.service.Accepted_Service;
import com.swiftLendFinancial.main.service.Rejected_Service;

@Service
public class Accepted_service_impl implements Accepted_Service {
	
	@Autowired
	Accepted_Repository ar;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	JavaMailSender jms;
	

	@Override
	public Accepted saveAccepted(Accepted a) {
		
		
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setFrom(fromMail);
		sm.setTo(a.getEmail());
		sm.setSubject("Approved For loan");
		sm.setText("Hello,"+a.getName()+"\n Congratulation! Based on the information submitted by you,"
		+"\n we are pleased to inform you of approval for car loan, for more details visit SwiftLend Branch."+
				"\n Sincerely,"+"\n {Loan Officer}");
		jms.send(sm);
		
		
		return ar.save(a);
		
		
		
	}

	
}
