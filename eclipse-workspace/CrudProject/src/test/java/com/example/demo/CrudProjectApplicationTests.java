package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Optionals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

import com.example.demo.dao.CustomerDetailsDao;
import com.example.demo.modal.CustomerDetails;
import com.example.demo.requestDto.CustomerDetailsModifyReqDto;
import com.example.demo.requestDto.CustomerDetailsReqDto;
import com.example.demo.service.CustomerDetailsService;

import jakarta.persistence.PersistenceException;

@SpringBootTest
class CrudProjectApplicationTests {

	@Test
	void contextLoads() {
	}
    
	
	
}
