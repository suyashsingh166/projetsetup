package com.ats.ATS.model;

import lombok.Builder;


@Builder
public class JwtResponse {

	private String jwtToken;
	private String username;
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
	}
	public JwtResponse(String jwtToken, String username) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
	}
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
