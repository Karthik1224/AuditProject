package com.example.demo.security;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	//Whenever unauthenticated user tries to access, it will return response
	public void commence(HttpServletRequest request, HttpServletResponse response,AuthenticationException authException) throws IOException, ServletException 
	{
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("Access Denied !" + authException.getMessage());

	}
}
