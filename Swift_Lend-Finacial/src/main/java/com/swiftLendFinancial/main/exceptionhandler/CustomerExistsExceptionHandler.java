package com.swiftLendFinancial.main.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.swiftLendFinancial.main.exception.EnquiryAlreadyExists;
import com.swiftLendFinancial.main.model.ErrorResponse;

@RestControllerAdvice
public class CustomerExistsExceptionHandler 
{

	@ExceptionHandler(value=EnquiryAlreadyExists.class)
	public ResponseEntity<ErrorResponse> handleEmployeeAlreadyExistException()
	{
		ErrorResponse er=new ErrorResponse(400, new Date(),"Customer Was Already Registerd..!");
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.BAD_REQUEST);
		
	}
}
