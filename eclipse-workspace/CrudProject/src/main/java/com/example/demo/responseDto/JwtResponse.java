package com.example.demo.responseDto;

public class JwtResponse {

	private String jwtToken;
	private String email;
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return email;
	}
	public void setUsername(String username) {
		this.email = username;
	}
	
}
