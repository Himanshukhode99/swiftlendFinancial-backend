package com.swiftLendFinancial.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.swiftLendFinancial.main.model.Accepted;
import com.swiftLendFinancial.main.model.Rejected;

public interface Accepted_Service {

	Accepted saveAccepted(Accepted a);

	Iterable<Accepted> getApproved();

	Optional<Accepted>  getApprovedByEmail(String email);

}
