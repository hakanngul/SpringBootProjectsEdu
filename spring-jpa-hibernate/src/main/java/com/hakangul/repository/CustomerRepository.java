package com.hakangul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hakangul.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
