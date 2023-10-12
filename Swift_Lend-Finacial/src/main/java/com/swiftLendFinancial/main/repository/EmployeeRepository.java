package com.swiftLendFinancial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiftLendFinancial.main.model.Employee;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{



public Employee findById (int employeeId);

public Employee deleteById(int employeeId);

}
