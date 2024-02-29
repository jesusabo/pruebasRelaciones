package com.relaciones.servicio.service;

import java.util.List;

import com.relaciones.servicio.dto.FacturaDTO;
import com.relaciones.servicio.entity.Factura;

public interface FacturaService {
	
	FacturaDTO save(FacturaDTO facturaDTO);
	void deleteById(Long id);	
	FacturaDTO update(Long id, FacturaDTO facturaDTO);
	List<FacturaDTO> getAll();
	FacturaDTO findById(Long id);	
	
	
}
