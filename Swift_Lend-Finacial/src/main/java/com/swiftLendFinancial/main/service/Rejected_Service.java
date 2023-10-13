package com.swiftLendFinancial.main.service;

import com.swiftLendFinancial.main.model.Rejected;

public interface Rejected_Service {

	Rejected saveRejected(Rejected r);

	public Iterable<Rejected> getallRejected();

}
