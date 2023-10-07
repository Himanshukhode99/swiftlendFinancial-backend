package com.swiftLendFinancial.main.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.swiftLendFinancial.main.model.Customer;
import com.swiftLendFinancial.main.model.User;



public interface CustomerService {

	Customer saveCustomer(String fieldText , String user,  String customerdoc, MultipartFile adhar, MultipartFile pan, MultipartFile photo, MultipartFile sign, MultipartFile salaryslip, MultipartFile drivingLiecense, MultipartFile bankstatement, MultipartFile incometaxreturn, MultipartFile carquatation, MultipartFile form16) throws Exception;

	Iterable<Customer> getallCustomer();

}
