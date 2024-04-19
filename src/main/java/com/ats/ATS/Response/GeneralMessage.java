package com.ats.ATS.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
 
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralMessage<T> {

	@JsonProperty("msq")
	private String msg;

	@JsonProperty("data")
	private T data;

	

	@JsonProperty("status_code")
	private int status_code;

	public GeneralMessage(String msg,int status_code) {
		this.msg = msg;
		
		this.status_code = status_code;
	}
	public GeneralMessage(String msg, T data,  int status_code) {
		this.msg = msg;
		this.data = data;
		
		this.status_code = status_code;
	}


	

}
