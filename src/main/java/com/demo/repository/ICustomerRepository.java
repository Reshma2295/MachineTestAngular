package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.CustomerDetails;

public interface ICustomerRepository extends JpaRepository<CustomerDetails, Integer> {

}
