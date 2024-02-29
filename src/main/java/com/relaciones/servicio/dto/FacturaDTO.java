package com.relaciones.servicio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.relaciones.servicio.entity.Factura;

public class FacturaDTO {

	
	private Long id;
	
//	@NotBlank
	private LocalDate fecha;
	
//	@NotEmpty(message = "El Total no debe estar vacio")
	private BigDecimal total;
	
	@NotNull(message = "Debe indicar una persona")
	private PersonaDTO personaDTO;

	public FacturaDTO() {
	}

	public FacturaDTO(Factura factura) {
		this.id = factura.getId();
		this.fecha = factura.getFecha();
		this.total = factura.getTotal();
		this.personaDTO = new PersonaDTO(factura.getPersona());
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

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	@Override
	public String toString() {
		return "FacturaDTO [id=" + id + ", fecha=" + fecha + ", total=" + total + ", personaDTO=" + personaDTO + "]";
	}

	
}
