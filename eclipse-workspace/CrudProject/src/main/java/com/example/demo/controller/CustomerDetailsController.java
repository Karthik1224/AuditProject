package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.requestDto.CustomerDetailsModifyReqDto;
import com.example.demo.requestDto.CustomerDetailsReqDto;
import com.example.demo.service.CustomerDetailsService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerDetailsController {

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@PostMapping("/add")
	@Operation(summary = "add customer", description = "It onboard the customer")
	public ResponseEntity<?> addCustomerDetails(@RequestBody CustomerDetailsReqDto customerDetailsReqDto) {

		return new ResponseEntity(customerDetailsService.addCustomerDetails(customerDetailsReqDto),HttpStatus.OK);

	}

	@GetMapping("/fetchAll")
	@Operation(summary = "fetch all customers", description = "Returns list of all customers")
	public ResponseEntity<?> fetchAllCustomerDetails() {
		return new ResponseEntity(customerDetailsService.fetchAllCustomerDetails(),HttpStatus.OK);
	}

	@PutMapping("/update")
	@Operation(summary = "updating the customer", description = "It updates the customer based on thier Aadhar number")
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerDetailsModifyReqDto customerDetailsModifyReqDto) {
		return new ResponseEntity( customerDetailsService.modifyCustomerDetails(customerDetailsModifyReqDto),HttpStatus.OK);
	}

	@DeleteMapping("/customer/delete")
	@Operation(summary = "deleting the customer", description = "It deletes the customer based on the id")
	public ResponseEntity<?> deleteCustomerByUUID(@RequestParam UUID id) {
		return new ResponseEntity (customerDetailsService.deleteCustomerByUUID(id),HttpStatus.OK);
	}

	@GetMapping("/customer/fetchByNumber")
	@Operation(summary = "find customer by mobile number", description = "Returns customer details based on mobile number")
	public ResponseEntity<?> fetchCustomerByNumber(@RequestParam String mobileNumber) {
		return new ResponseEntity( customerDetailsService.fetchCustomerByMobileNumber(mobileNumber),HttpStatus.OK);
	}
}
