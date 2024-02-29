package com.relaciones.servicio.dto;

public class RegistroDTO {
	
	private String nombre;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String perfil;
	
	
	public RegistroDTO() {
		
	}

	public RegistroDTO(String nombre, String username, String email, String password,String perfil) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.password = password;
		this.perfil= perfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	

}
