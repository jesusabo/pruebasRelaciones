package com.relaciones.servicio.seguridad;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.relaciones.servicio.entity.Persona;
import com.relaciones.servicio.entity.Rol;
import com.relaciones.servicio.entity.Usuario;
import com.relaciones.servicio.excepciones.ResourceNotFoundException;
import com.relaciones.servicio.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		Usuario usuario = usuarioRepository.findByUsernameOrEmail(username, username)
				.orElseThrow(()-> new ResourceNotFoundException("Usuario","usernameOrEmail", username));
		verRoles(usuario.getRoles());
		return new User(usuario.getEmail(), usuario.getPassword(), mapearRoles(usuario.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles){
		return roles.stream().map(rol-> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}

	private void verRoles(Set<Rol> roles) {
		
		for(Rol r: roles) {
			System.out.println("Rol: -> id: "+r.getId()+ " -> nombre: "+r.getNombre());
		}
		
		List<Persona> l = roles.stream().map(rol -> new Persona(10L,"a","b")).collect(Collectors.toList());
		System.out.println(l);
		
	}
}
