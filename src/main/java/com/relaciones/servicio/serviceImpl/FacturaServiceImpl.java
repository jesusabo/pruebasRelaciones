package com.relaciones.servicio.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relaciones.servicio.controller.FacturaController;
import com.relaciones.servicio.dto.FacturaDTO;
import com.relaciones.servicio.entity.Factura;
import com.relaciones.servicio.excepciones.ResourceNotFoundException;
import com.relaciones.servicio.repository.FacturaRepository;
import com.relaciones.servicio.service.FacturaService;
import com.relaciones.servicio.service.PersonaService;

@Service
public class FacturaServiceImpl implements FacturaService{
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(FacturaServiceImpl.class);
	
	@Autowired
	private FabricaFacturaService fabricaFacturaService;

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	public FacturaDTO save(FacturaDTO facturaDTO) {
		log.info("Save "+facturaDTO);
		return fabricaFacturaService.convertFacturaToFacturaDTO(facturaRepository.save(fabricaFacturaService.convertFacturaDTOToFactura(facturaDTO)));
	}

	@Override
	public List<FacturaDTO> getAll() {
		return fabricaFacturaService.convertFacturasToFacturasDTO(facturaRepository.findAll());
	}

	@Override
	public void deleteById(Long id) {
		Factura facturaDB = facturaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Factura", "id", String.valueOf(id)));
		facturaRepository.delete(facturaDB);	
	}

	@Override
	public FacturaDTO update(Long id, FacturaDTO facturaDTO) {
		
		Optional<Factura> facturaDB = facturaRepository.findById(id);
		System.out.println("update 0");
		if(facturaDB.isPresent()) {
			Factura f = facturaDB.get();
			f.setTotal(facturaDTO.getTotal());
			
			return fabricaFacturaService.convertFacturaToFacturaDTO(facturaRepository.save(f));
		}
		System.out.println("update 1");
		
		throw new ResourceNotFoundException("Factura","id",String.valueOf(id));
	}

	@Override
	public FacturaDTO findById(Long id) {
		
		Optional<Factura> factura = facturaRepository.findById(id);
		
		if(factura.isPresent()) {
			Factura facturaDB = factura.get();
			return fabricaFacturaService.convertFacturaToFacturaDTO(facturaDB);
		}
		throw new ResourceNotFoundException("Factura", "id", String.valueOf(id));
	}
	
	

}
