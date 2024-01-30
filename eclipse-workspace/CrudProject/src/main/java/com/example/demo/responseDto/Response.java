package com.example.demo.responseDto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;

	private String message;

	@SuppressWarnings("rawtypes")
	private List resultObj;

	public Response() {
	}

	public Response(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public Response(String status, String message, List<?> resultObj) {
		this.status = status;
		this.message = message;
		this.resultObj = resultObj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@SuppressWarnings("rawtypes")
	public List getResultObj() {
		return resultObj;
	}

	@SuppressWarnings("rawtypes")
	public void setResultObj(List resultObj) {
		this.resultObj = resultObj;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", resultObj=" + resultObj + "]";
	}

}

