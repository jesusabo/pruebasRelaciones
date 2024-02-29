package com.relaciones.servicio.dto;

import javax.validation.constraints.Size;

import com.relaciones.servicio.entity.Persona;

public class PersonaDTO {
	
	private Long id;
	
	@Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
	private String nombre;
	
	private String apellido;
	
	public PersonaDTO() {
		
	}
	
	public PersonaDTO(Persona persona) {
		this.id= persona.getId();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "PersonaDTO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	

}
