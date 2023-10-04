package com.swiftLendFinancial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiftLendFinancial.main.model.CustomerEnquiry;

@Repository
public interface Enquiry_Repository extends JpaRepository<CustomerEnquiry, Integer> {

	CustomerEnquiry findByEmail(String email);

}
 