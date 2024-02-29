package com.relaciones.servicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relaciones.servicio.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
