package com.dev.posts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.posts.entities.Rol;
import com.dev.posts.repositories.RolRepo;

@Service
public class RolService {
	@Autowired
	private RolRepo rolRepo;
	
	public void crearRol(Rol rol) {
		rolRepo.save(rol);
	}
	
	public Rol getRol(String tipo) {
		return rolRepo.findRolByTipo(tipo);
	}
}
