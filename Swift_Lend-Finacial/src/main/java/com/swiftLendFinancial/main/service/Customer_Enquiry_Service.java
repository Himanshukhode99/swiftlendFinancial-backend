package com.swiftLendFinancial.main.service;

import java.util.List;

import com.swiftLendFinancial.main.model.CustomerEnquiry;

public interface Customer_Enquiry_Service {

	CustomerEnquiry save(CustomerEnquiry c);

	List<CustomerEnquiry> getEnquiries();

	CustomerEnquiry getEnquiriesByMail(String email);

	void deleteCustomerEnquiry(String email);

}
