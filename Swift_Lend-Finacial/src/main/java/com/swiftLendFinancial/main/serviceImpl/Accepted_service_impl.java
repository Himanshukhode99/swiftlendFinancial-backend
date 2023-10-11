package com.swiftLendFinancial.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Accepted saveAccepted(Accepted a) {
		
		return ar.save(a);
	}

	
}
