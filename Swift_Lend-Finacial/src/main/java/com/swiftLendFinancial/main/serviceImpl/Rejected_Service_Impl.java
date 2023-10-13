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
		sm.setText("Hello,"+r.getFirst_name()+" "+r.getLast_name()+
				"We regret to inform you that your loan apllication for maorttage loan to our organization has been declined."
				+"The reason for this decline is that you do not meet the required criteria of cibil."+"\n Cibil Scor:-"+reject.getCibilscore()+"\n CibilStatus:-"+reject.getCibilstatus()+
				"Sincerely,"+"\n {Loan Officer}");
		
		jms.send(sm);
		
		return reject;
	}

	@Override
	public Iterable<Rejected> getallRejected() {
	
		return rr.findAll();
	
	}
	

}
