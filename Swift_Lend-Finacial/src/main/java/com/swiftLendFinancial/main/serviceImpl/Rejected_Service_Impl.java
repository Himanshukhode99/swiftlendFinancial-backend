package com.swiftLendFinancial.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.swiftLendFinancial.main.model.Rejected;
import com.swiftLendFinancial.main.repository.Rejected_Repository;
import com.swiftLendFinancial.main.service.Rejected_Service;

@Service
public class Rejected_Service_Impl implements Rejected_Service 
{
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	JavaMailSender jms;

	
	@Autowired
	Rejected_Repository rr;

	@Override
	public Rejected saveRejected(Rejected r) 
	{
		Rejected reject=rr.save(r);
		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom(fromMail);
		sm.setTo(reject.getEmail());
		sm.setSubject("Reject loan application");
		sm.setText("Your Loan application was Rejected Because \n Cibil Scor:-"+reject.getCibilscore()+"\n CibilStatus:-"+reject.getCibilstatus());
		
		jms.send(sm);
		
		return reject;
	}

}
