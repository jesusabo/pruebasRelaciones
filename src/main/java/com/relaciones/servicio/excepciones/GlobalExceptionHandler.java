package com.relaciones.servicio.excepciones;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.relaciones.servicio.dto.ErrorDTO;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDTO> recursoNoEncontrado(ResourceNotFoundException exception, WebRequest webRequest){
		
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setDate(LocalDate.now());
		errorDTO.setException(exception.getMessage());
		errorDTO.setDescription(webRequest.getDescription(false));
		
		return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String nombreCampo = ((FieldError)error).getField();
			String mensaje = error.getDefaultMessage();
			
			map.put(nombreCampo, mensaje);
		});
		
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	

}
