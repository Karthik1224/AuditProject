package com.example.demo;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImple implements AuditorAware<String>{

	
	//This will help us to define values for createdBy and modifiedBy
	@Override
	public Optional<String>getCurrentAuditor()
	{
		return Optional.of("karthik");
	}
}
