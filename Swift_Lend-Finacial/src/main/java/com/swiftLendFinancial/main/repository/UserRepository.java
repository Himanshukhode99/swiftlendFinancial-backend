package com.swiftLendFinancial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiftLendFinancial.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{

}
