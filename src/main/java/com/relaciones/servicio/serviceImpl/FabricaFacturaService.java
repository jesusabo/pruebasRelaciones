package com.relaciones.servicio.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.relaciones.servicio.dto.FacturaDTO;
import com.relaciones.servicio.entity.Factura;

@Service
public class FabricaFacturaService {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(FabricaFacturaService.class);
	
	public Factura convertFacturaDTOToFactura(FacturaDTO facturaDTO) {
		log.info("convertFacturaDTOToFactura "+facturaDTO);
		return new Factura(facturaDTO);
	}
	
	public FacturaDTO convertFacturaToFacturaDTO(Factura factura) {
		return new FacturaDTO(factura);
	}
	
	
	public List<FacturaDTO> convertFacturasToFacturasDTO(List<Factura> facturas){
		List<FacturaDTO> facturasDTO = new ArrayList<>();
		
		facturas.stream().forEach(f -> {
			facturasDTO.add(new FacturaDTO(f));
		});
		
		return facturasDTO;
	}

}
