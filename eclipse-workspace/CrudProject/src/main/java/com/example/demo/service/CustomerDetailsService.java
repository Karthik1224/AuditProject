package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.constants.Constant;
import com.example.demo.dao.CustomerDetailsDao;
import com.example.demo.modal.CustomerDetails;
import com.example.demo.requestDto.CustomerDetailsModifyReqDto;
import com.example.demo.requestDto.CustomerDetailsReqDto;
import com.example.demo.responseDto.Response;

@Service
public class CustomerDetailsService {

	@Autowired
	private CustomerDetailsDao customerDetailsDao;

	public Response addCustomerDetails(CustomerDetailsReqDto customerDetailsReqDto) {
		try {
			CustomerDetails customerDetails = new CustomerDetails();
			customerDetails.setFirstName(customerDetailsReqDto.getFirstName());
			customerDetails.setLastName(customerDetailsReqDto.getLastName());
			customerDetails.setDob(customerDetailsReqDto.getDob());
			customerDetails.setAadharNumber(customerDetailsReqDto.getAadharNumber());
			customerDetails.setMobileNumber(customerDetailsReqDto.getMobileNumber());
			customerDetails.setGender(customerDetailsReqDto.getGender());
			customerDetailsDao.save(customerDetails);
			return new Response(Constant.SUCCESS_API_CODE, Constant.SUCCESS_API_MESSAGE,
					new ArrayList<>(Arrays.asList(customerDetails)));

		} catch (Exception e) {
			return new Response(Constant.FAILURE_API_CODE, Constant.FAILURE_API_MESSAGE, new ArrayList<>());
		}
	}

	public Response fetchAllCustomerDetails() {

		try {
			List<CustomerDetails> listOfCustomers = customerDetailsDao.findAll();

			return new Response(Constant.SUCCESS_API_CODE, Constant.SUCCESS_FETCH_CUSTOMER, listOfCustomers);
		} catch (Exception e) {

			return new Response(Constant.FAILURE_API_CODE, Constant.FAILURE_FETCH_CUSTOMER, new ArrayList<>());
		}
	}

	public Response modifyCustomerDetails(CustomerDetailsModifyReqDto customerDetailsModifyReqDto) {

		try {
			Optional<CustomerDetails> optionalCustomer = customerDetailsDao
					.findById(customerDetailsModifyReqDto.getId());

			if (optionalCustomer.isEmpty()) {

				return new Response(Constant.SUCCESS_API_CODE, Constant.FAILURE_MODIFY_CUSTOMER, new ArrayList<>());

			} else {
				CustomerDetails customerDetails = optionalCustomer.get();
				customerDetails.setFirstName(customerDetailsModifyReqDto.getFirstName());
				customerDetails.setLastName(customerDetailsModifyReqDto.getLastName());
				customerDetails.setDob(customerDetailsModifyReqDto.getDob());
				customerDetails.setAadharNumber(customerDetailsModifyReqDto.getAadharNumber());
				customerDetails.setMobileNumber(customerDetailsModifyReqDto.getMobileNumber());
				customerDetails.setGender(customerDetailsModifyReqDto.getGender());
				customerDetailsDao.save(customerDetails);

				return new Response(Constant.SUCCESS_API_CODE, Constant.SUCCESS_MODIFY_CUSTOMER,
						new ArrayList<>(Arrays.asList(customerDetails)));
			}
		} catch (Exception e) {

			return new Response(Constant.FAILURE_API_CODE, Constant.FAILURE_API_MESSAGE, new ArrayList<>());
		}

	}

	public Response deleteCustomerByUUID(UUID id) {
		try {
			if (customerDetailsDao.existsById(id)) {
				customerDetailsDao.deleteById(id);

				return new Response(Constant.SUCCESS_API_CODE, "Successfully deleted", new ArrayList<>());
			} else {

				return new Response(Constant.SUCCESS_API_CODE, "Please provide valid id", new ArrayList<>());
			}
		} catch (Exception e) {

			return new Response(Constant.FAILURE_API_CODE, Constant.FAILURE_API_MESSAGE, new ArrayList<>());
		}

	}

	public Response fetchCustomerByMobileNumber(String mobileNumber) {
		try {
			CustomerDetails customer = customerDetailsDao.findByMobileNumber(mobileNumber);
			if (customer == null) {

				return new Response(Constant.SUCCESS_API_CODE, "Please provide valid mobile number", new ArrayList<>());
			} else {

				return new Response(Constant.SUCCESS_API_CODE, Constant.SUCCESS_API_MESSAGE,
						new ArrayList<>(Arrays.asList(customer)));
			}
		} catch (Exception e) {

			return new Response(Constant.FAILURE_API_CODE, Constant.FAILURE_API_MESSAGE, new ArrayList<>());
		}
	}

}