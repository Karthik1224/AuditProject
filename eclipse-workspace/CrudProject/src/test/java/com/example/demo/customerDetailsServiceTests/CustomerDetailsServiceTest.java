package com.example.demo.customerDetailsServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.constants.Constant;
import com.example.demo.dao.CustomerDetailsDao;
import com.example.demo.modal.CustomerDetails;
import com.example.demo.requestDto.CustomerDetailsModifyReqDto;
import com.example.demo.requestDto.CustomerDetailsReqDto;
import com.example.demo.responseDto.Response;
import com.example.demo.service.CustomerDetailsService;

import jakarta.persistence.PersistenceException;

@SpringBootTest
public class CustomerDetailsServiceTest {

	@Mock
	private CustomerDetailsDao customerDetailsDao;

	@InjectMocks
	private CustomerDetailsService customerDetailsService;

	@Test
	public void addCustomerDetails() {
		CustomerDetailsReqDto reqDto = new CustomerDetailsReqDto();
		Mockito.when(customerDetailsDao.save(Mockito.any())).thenReturn(null);
		Response res = customerDetailsService.addCustomerDetails(reqDto);

		assertEquals(Constant.SUCCESS_API_CODE, res.getStatus());
	}

	@Test
	public void fetchCustomerDetails() {

		Mockito.when(customerDetailsDao.findAll()).thenReturn(new ArrayList<>());
		Response res = customerDetailsService.fetchAllCustomerDetails();
		assertEquals(Constant.SUCCESS_API_CODE, res.getStatus());

	}

	@Test
	public void updateCustomerDetails() {
		Optional<CustomerDetails> optional = customerDetailsDao.findById(null);
		CustomerDetailsModifyReqDto modifyDto = new CustomerDetailsModifyReqDto();
		Mockito.when(customerDetailsDao.findById(Mockito.any())).thenReturn(optional);
		Response res = customerDetailsService.modifyCustomerDetails(modifyDto);
		assertEquals(Constant.SUCCESS_API_CODE, res.getStatus());
	}

	@Test
	public void deleteById() {
		doThrow(new PersistenceException("Exception occured")).when(customerDetailsDao).findById(Mockito.any());
		Response res = customerDetailsService.deleteCustomerByUUID(null);
		assertEquals(Constant.SUCCESS_API_CODE, res.getStatus());
	}

	@Test
	public void fetchByNumber() {
		Mockito.when(customerDetailsDao.findByMobileNumber(Mockito.any())).thenReturn(null);
		Response res = customerDetailsService.fetchCustomerByMobileNumber(null);
		assertEquals(Constant.SUCCESS_API_CODE, res.getStatus());
	}

}
