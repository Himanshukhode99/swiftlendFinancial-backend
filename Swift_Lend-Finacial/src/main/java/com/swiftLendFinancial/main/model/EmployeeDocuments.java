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
public class EmployeeDocuments 
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
 	

}
