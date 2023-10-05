package com.swiftLendFinancial.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailSending 
{
	private String toEmailId;
	private String mailSubject;
	private String mailText;

}
