package com.relaciones.servicio.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relaciones.servicio.dto.FacturaDTO;
import com.relaciones.servicio.dto.PersonaDTO;
import com.relaciones.servicio.entity.Factura;
import com.relaciones.servicio.entity.Persona;
import com.relaciones.servicio.service.FacturaService;
import com.relaciones.servicio.service.PersonaService;
import com.relaciones.servicio.serviceImpl.FabricaPersonaService;



@RestController
@RequestMapping("/factura")
public class FacturaController {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(FacturaController.class);
		
	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private PersonaService personaService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping()
	public ResponseEntity<FacturaDTO> guardar(@RequestBody @Valid FacturaDTO facturaDTO){
		log.info("Guardar Factura: "+facturaDTO);
		return ResponseEntity.ok().body(facturaService.save(facturaDTO));
	}
	
	@GetMapping()
	public ResponseEntity<List<FacturaDTO>> listarFacturas(){
		return ResponseEntity.ok().body(facturaService.getAll());
	}
	
	@DeleteMapping("/{id}")
	public String eliminarFactura(@PathVariable String id) {
		System.out.println("Id: "+id);
		facturaService.deleteById(Long.parseLong(id));
		return "Eliminado";
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<FacturaDTO> guardarFactura(@RequestBody FacturaDTO facturaDTO, @PathVariable Long id){
		
		PersonaDTO persona = personaService.findById(id);
		FacturaDTO facturaGuardar = facturaDTO;
		facturaGuardar.setPersonaDTO(persona);
		return ResponseEntity.ok().body(facturaService.save(facturaGuardar));	
		
	}
	

}
