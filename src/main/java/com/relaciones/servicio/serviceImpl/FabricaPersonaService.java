package com.relaciones.servicio.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.relaciones.servicio.dto.PersonaDTO;
import com.relaciones.servicio.entity.Persona;

@Service
public class FabricaPersonaService {

	public Persona convertPersonaDTOToPersona(PersonaDTO personaDTO) {
		return new Persona(personaDTO);
	}
	
	
	public PersonaDTO convertPersonaToPersonaDTO(Persona persona) {
		return new PersonaDTO(persona);
	}
	
	
	public List<PersonaDTO> convertPersonasToPersonasDTO(List<Persona> personas){
		List<PersonaDTO> personasDTO = new ArrayList<>();
		
		personas.stream().forEach(p -> {
			personasDTO.add(new PersonaDTO(p));
		});
		
		return personasDTO;
		
	}
	
}
