package com.swiftLendFinancial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiftLendFinancial.main.model.CustomerEnquiry;

@Repository
public interface Customer_Enquiry_Repository extends JpaRepository<CustomerEnquiry,String> {

	public CustomerEnquiry findByEmail(String email);

	public void deleteByEmail(String email);

}
 