package com.relaciones.servicio.service;

import java.util.List;

import com.relaciones.servicio.dto.PersonaDTO;
import com.relaciones.servicio.entity.Persona;

public interface PersonaService {
	
	PersonaDTO save(PersonaDTO personaDTO);
	void deleteById(Long id);
	PersonaDTO update(Long id, PersonaDTO personaDTO);
	List<PersonaDTO> getAll();	
	PersonaDTO findById(Long id);
	
	

}
