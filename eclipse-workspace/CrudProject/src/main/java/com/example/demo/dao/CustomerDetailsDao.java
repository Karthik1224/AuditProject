package com.example.demo.dao;



import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.CustomerDetails;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerDetailsDao extends JpaRepository<CustomerDetails, UUID> {

	
//	@Transactional
//	@Modifying
//	void deleteCustomerDetailsByAadharNumber(String aadharNumber);
	
	public CustomerDetails findByMobileNumber(String mobileNumber);
}
