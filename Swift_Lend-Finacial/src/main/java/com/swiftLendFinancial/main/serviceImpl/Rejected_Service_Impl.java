package com.swiftLendFinancial.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiftLendFinancial.main.model.Rejected;
import com.swiftLendFinancial.main.repository.Rejected_Repository;
import com.swiftLendFinancial.main.service.Rejected_Service;

@Service
public class Rejected_Service_Impl implements Rejected_Service {
	
	@Autowired
	Rejected_Repository rr;

	@Override
	public Rejected saveRejected(Rejected r) {
		
		return rr.save(r);
	}

}
