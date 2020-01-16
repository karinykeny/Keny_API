package com.keny.api.exception.handler;

import org.springframework.stereotype.Component;

@Component
public class ErrorDetails {

	private Integer status;
	private String message;
	private String messageDev;

	public ErrorDetails() {
	}

	public ErrorDetails(Integer status, String message, String messageDev) {
		this.status = status;
		this.message = message;
		this.messageDev = messageDev;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDev() {
		return messageDev;
	}

	public void setMessageDev(String messageDev) {
		this.messageDev = messageDev;
	}

}
