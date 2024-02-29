package com.relaciones.servicio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.relaciones.servicio.dto.PersonaDTO;


@Entity
@Table(name = "personas")
public class Persona implements Serializable{

	private static final long serialVersionUID = 3862161755595696877L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	
	
//	@OneToMany( mappedBy = "persona")
//	@JsonManagedReference
//	private List<Factura> facturas = new ArrayList<>();
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Address> direcciones;

	public Persona() {
		super();
	}

	public Persona(Long id, String nombre, String apellido
//			, List<Factura> facturas
			) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
//		this.facturas = facturas;
	}
	
	public Persona(PersonaDTO personaDTO) {
		this.id = personaDTO.getId();
		this.nombre = personaDTO.getNombre();
		this.apellido = personaDTO.getApellido();
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
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
	

//	public List<Factura> getFacturas() {
//		return facturas;
//	}
//
//	public void setFacturas(List<Factura> facturas) {
//		this.facturas = facturas;
//	}
	
	
	
	
	
}
