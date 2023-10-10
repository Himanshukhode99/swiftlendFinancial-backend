package com.swiftLendFinancial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiftLendFinancial.main.model.Rejected;

@Repository
public interface Rejected_Repository extends JpaRepository<Rejected, Integer> {

}
