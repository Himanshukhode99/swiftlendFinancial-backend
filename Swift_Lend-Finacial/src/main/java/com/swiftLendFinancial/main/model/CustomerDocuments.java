package com.swiftLendFinancial.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class CustomerDocuments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int documentId;
	@Lob
	private byte[] aadharCard;
	@Lob
	private byte[] panCard;
	@Lob
	private byte[] profilePhoto;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] salarySlip;
	@Lob
	private byte[] drivingLicense;
	@Lob
	private byte[] bankStatement;
	@Lob
	private byte[] carQuatation;
	@Lob
	private byte[] form16;
	@Lob
	private byte[] incomeTaxReturn;
	

}
