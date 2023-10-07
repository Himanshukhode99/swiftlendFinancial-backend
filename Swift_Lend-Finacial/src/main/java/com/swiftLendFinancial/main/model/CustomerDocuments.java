package com.swiftLendFinancial.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerDocuments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int documentId;
	@Lob
	private byte[] aadharcard;
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] profile_photo;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] salary_slip;
	@Lob
	private byte[] driving_license;
	@Lob
	private byte[] bank_statement;
	@Lob
	private byte[] car_quatation;
	@Lob
	private byte[] form16;
	@Lob
	private byte[] income_tax_return;
	

}
