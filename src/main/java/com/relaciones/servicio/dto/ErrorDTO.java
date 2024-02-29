package com.relaciones.servicio.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ErrorDTO implements Serializable{
	
	private static final long serialVersionUID = 6264277936167870278L;
	
	private LocalDate date;
	private String exception;
	private String description;
	
	public ErrorDTO() {
		
	}
	
	public ErrorDTO(LocalDate date, String exception, String description) {
		super();
		this.date = date;
		this.exception = exception;
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
