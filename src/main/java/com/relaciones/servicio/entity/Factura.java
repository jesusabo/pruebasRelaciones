package com.relaciones.servicio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.relaciones.servicio.dto.FacturaDTO;

@Entity
@Table(name="facturas")
public class Factura implements Serializable{

	private static final long serialVersionUID = 5061854905149656555L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fecha;
	
	private BigDecimal total;
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonBackReference
	private Persona persona;

	public Factura() {
		super();
	}

	public Factura(Long id, LocalDate fecha, BigDecimal total, Persona persona) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.persona = persona;
	}
	
	public Factura(FacturaDTO facturaDTO) {
		this.id = facturaDTO.getId();
		this.fecha = facturaDTO.getFecha();
		this.total = facturaDTO.getTotal();
		this.persona = new Persona(facturaDTO.getPersonaDTO());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
}
