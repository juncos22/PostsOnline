package com.dev.posts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.posts.entities.Categoria;
import com.dev.posts.repositories.CategoriaRepo;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepo categoriaRepo;
	
	public void registrarCategoria(Categoria c) {
		categoriaRepo.save(c);
	}
	
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		for (Categoria categoria : categoriaRepo.findAll()) {
			categorias.add(categoria);
		}
		return categorias;
	}
	
	public Categoria buscarCategoria(long id) {
		return categoriaRepo.findById(id).orElse(null);
	}
}
