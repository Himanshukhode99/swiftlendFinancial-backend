package com.swiftLendFinancial.main.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse 
{
	private int statusCode;
	private Date responceTimeStamp;
	private String responseMessage;

}
