package com.relaciones.servicio.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.OneToMany;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relaciones.servicio.service.FacturaService;
import com.relaciones.servicio.service.PersonaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relaciones.servicio.dto.PersonaDTO;
import com.relaciones.servicio.entity.Factura;
import com.relaciones.servicio.entity.Persona;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	
	
	@PostMapping
	public ResponseEntity<PersonaDTO> guardar(@RequestBody @Valid PersonaDTO personaDTO){
		return ResponseEntity.ok().body(personaService.save(personaDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<PersonaDTO>> listar(){
		return ResponseEntity.ok().body(personaService.getAll());
	}

	
	@GetMapping("/httpServletRequest")
	public String pruebaHttpServletrequest(HttpServletRequest request) {
		
		String param = request.getParameter("nombre");//getParameter siempre devuelve un String
		System.out.println(param);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("nombre", "jesus");
		map.put("apellido", "bringas");
		map.put("telefonos", Arrays.asList(new HashMap<>().put("claro", "1231231")));
		
		String json=null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(map);
			System.out.println(">>>>: "+json);
		} catch (JsonProcessingException e) {
			System.out.println("error en mapper");
		}
		
		System.out.println(request.getContextPath());
		
		
		return json;
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarPersona(@PathVariable Long id){
		System.out.println("Delete de Persona");
		personaService.deleteById(id);
		return ResponseEntity.ok().body("Persona con id: "+id+" eliminada correctamente");
	}
	

}
