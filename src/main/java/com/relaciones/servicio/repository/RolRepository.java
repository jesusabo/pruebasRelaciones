package com.relaciones.servicio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relaciones.servicio.entity.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

	public Optional<Rol> findByNombre(String nombre);
	
}
