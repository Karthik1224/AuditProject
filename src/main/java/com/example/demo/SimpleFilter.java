package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import org.slf4j.LoggerFactory;
import org.springframework.core.serializer.Deserializer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;





@Component
public class SimpleFilter extends OncePerRequestFilter {

	private static final Logger log = (Logger) LoggerFactory.getLogger(SimpleFilter.class);
	private final ObjectMapper objectMapper = new ObjectMapper();
	@Override
	protected void doFilterInternal(HttpServletRequest  request, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException{
		
		 
		try {
			URI uri = new URI(request.getRequestURL().toString());
			  String path = uri.getPath();
			  log.info("path :{}",path);
		         String[]arr = path.split("/");
		         log.info("api end point :{}",arr[arr.length-1]);
		         ResponseWrapper responseWrapper = new ResponseWrapper(res);
				 chain.doFilter(request, responseWrapper);
				  byte[] responseData = responseWrapper.getCachedResponseBody();
				  String responseBody = new String(responseData, res.getCharacterEncoding());
				  log.info("response body :{}", responseBody);
				  res.getWriter().write(responseBody);
				  ResponseObj response = objectMapper.readValue(responseBody,ResponseObj.class);
				  log.info("response object :{}",response.getStatus());
				  

			       
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		
	}
	
	
}
