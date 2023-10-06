package com.swiftLendFinancial.main.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.swiftLendFinancial.main.model.Customer;



public interface CustomerService {

	Customer saveCustomer(String fieldText, String customerdoc, MultipartFile adhar, MultipartFile pan, MultipartFile photo, MultipartFile sign, MultipartFile salaryslip, MultipartFile drivingLiecense, MultipartFile bankstatement, MultipartFile incometaxreturn, MultipartFile carquatation, MultipartFile form16) throws IOException;

	Iterable<Customer> getallCustomer();

}
