package com.relaciones.servicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relaciones.servicio.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
