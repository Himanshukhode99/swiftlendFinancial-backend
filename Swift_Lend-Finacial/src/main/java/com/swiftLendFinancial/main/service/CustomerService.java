package com.swiftLendFinancial.main.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.swiftLendFinancial.main.model.Customer;
import com.swiftLendFinancial.main.model.User;



public interface CustomerService {

	Customer saveCustomer(String fieldText, MultipartFile adhar, MultipartFile pan, MultipartFile photo, MultipartFile sign, MultipartFile salaryslip, MultipartFile drivingLiecense, MultipartFile bankstatement, MultipartFile carquatation, MultipartFile form16, MultipartFile incometaxreturn) throws Exception;

	Iterable<Customer> getallCustomer();

}
