package com.relaciones.servicio.excepciones;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -751454789557736852L;
	
	private String nombreRecurso;
	private String nombreCampo;
	private String valorCampo;

	public ResourceNotFoundException() {
		super();
	}
	
	
	
	public ResourceNotFoundException(String nombreRecurso, String nombreCampo, String valorCampo) {
		super(String.format("Recurso [%s] con [%s] : [%s] no encontrado", nombreRecurso,nombreCampo,valorCampo));		
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.valorCampo = valorCampo;
	}


	
	
	

}
