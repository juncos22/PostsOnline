package com.dev.posts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.posts.entities.Usuario;
import com.dev.posts.repositories.UsuarioRepo;

@Service
public class UsuarioService implements UserDetailsService {
	@Autowired
	private UsuarioRepo usuarioRepo;
	
	private String encodePassword(String rawPassword) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(rawPassword);
	}
	
	public void crearUsuario(Usuario u) {
		u.setContrasenia(encodePassword(u.getContrasenia()));
		usuarioRepo.save(u);
	}
	
	public Optional<Usuario> getUsuario(long id) {
		return usuarioRepo.findById(id);
	}
	
	public Optional<Usuario> buscarUsuario(String nombre) {
		return usuarioRepo.findByNombre(nombre);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = usuarioRepo.findByNombre(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		if (optional.isPresent()) {
			Usuario u = optional.get();
			authorities.add(new SimpleGrantedAuthority(u.getRol().getTipo()));
			return new User(u.getNombre(), u.getContrasenia(), authorities);
		}
		
		return new User(username, username, authorities);
	}
	
}
