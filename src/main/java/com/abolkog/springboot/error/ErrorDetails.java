package com.abolkog.springboot.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {
	
	private String messae;

	private String uri;
	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern ="dd-MM-yyyy hh:mm:ss" )
	private Date timesTamp;
	
	
	public ErrorDetails() {
		this.timesTamp=new Date();
	}
	
	
	public ErrorDetails(String messae, String uri) {
		this();
		this.messae = messae;
		this.uri = uri;
	}
	public String getMessae() {
		return messae;
	}
	public void setMessae(String messae) {
		this.messae = messae;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Date getTimesTamp() {
		return timesTamp;
	}
	public void setTimesTamp(Date timesTamp) {
		this.timesTamp = timesTamp;
	}

	
	
	
}
