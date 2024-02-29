package com.relaciones.servicio.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relaciones.servicio.dto.LoginDTO;
import com.relaciones.servicio.dto.RegistroDTO;
import com.relaciones.servicio.entity.Rol;
import com.relaciones.servicio.entity.Usuario;
import com.relaciones.servicio.repository.RolRepository;
import com.relaciones.servicio.repository.UsuarioRepository;


@RestController
@RequestMapping("/autenticacion")
public class AuthController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/iniciarSesion")
	public ResponseEntity<String> autenticateUser(@RequestBody LoginDTO loginDTO){
		System.out.println("iniciarSesion");
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseEntity<String>("Inicio de sesion correcto", HttpStatus.OK);
	
	}
	
	@PostMapping
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO){
		
		if(usuarioRepository.existsByUsername(registroDTO.getUsername())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de usuario ya existe");
		}
		
		if(usuarioRepository.existsByEmail(registroDTO.getEmail())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El email ya existe");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setUsername(registroDTO.getUsername());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
		
		Rol roles;
		
		if(registroDTO.getPerfil().equalsIgnoreCase("user")) {
			roles = rolRepository.findByNombre("ROLE_USER").get();
		}else {
			roles = rolRepository.findByNombre("ROLE_ADMIN").get();
		}
		System.out.println(roles);
		usuario.setRoles(Collections.singleton(roles));
		
		usuarioRepository.save(usuario);
		
		return new ResponseEntity<>("Usuario registrado Correctamente", HttpStatus.OK);
		
	}

}
