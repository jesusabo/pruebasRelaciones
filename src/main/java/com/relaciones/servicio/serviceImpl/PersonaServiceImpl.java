package com.relaciones.servicio.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relaciones.servicio.dto.PersonaDTO;
import com.relaciones.servicio.entity.Persona;
import com.relaciones.servicio.excepciones.ResourceNotFoundException;
import com.relaciones.servicio.repository.PersonaRepository;
import com.relaciones.servicio.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private FabricaPersonaService fabricaPersonaService;

	@Override
	public PersonaDTO save(PersonaDTO personaDTO) {
		return fabricaPersonaService.convertPersonaToPersonaDTO(personaRepository.save(fabricaPersonaService.convertPersonaDTOToPersona(personaDTO)));
	}

	@Override
	public List<PersonaDTO> getAll() {
		return fabricaPersonaService.convertPersonasToPersonasDTO(personaRepository.findAll());
	}

	@Override
	public PersonaDTO findById(Long id) {		
		Optional<Persona> persona = personaRepository.findById(id);
		
		if(persona.isPresent()) {
			Persona personaDB = persona.get();
			return fabricaPersonaService.convertPersonaToPersonaDTO(personaDB);
		}
		throw new ResourceNotFoundException("Persona", "id", String.valueOf(id));
	}

	@Override
	public void deleteById(Long id) {
		Persona persona = personaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Persona", "id", String.valueOf(id)));
		personaRepository.delete(persona);		
	}

	@Override
	public PersonaDTO update(Long id, PersonaDTO personaDTO) {
		Persona personaDB = personaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Persona", "id",String.valueOf(id)));
		personaDB.setNombre(personaDTO.getNombre());
		return fabricaPersonaService.convertPersonaToPersonaDTO(personaRepository.save(personaDB));
	}

}
