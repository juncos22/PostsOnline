package com.dev.posts.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.posts.entities.Articulo;
import com.dev.posts.entities.Categoria;
import com.dev.posts.entities.Usuario;
import com.dev.posts.repositories.ArticuloRepo;

@Service
public class ArticuloService {
	@Autowired
	private ArticuloRepo articuloRepo;
	
	public void guardarArticulo(Articulo a, Usuario u) {
		a.setUsuario(u);
		articuloRepo.save(a);
	}
	
	public List<Articulo> listarArticulos() {
		List<Articulo> articulos = new ArrayList<Articulo>();
		for (Articulo articulo : articuloRepo.findAll()) {
			articulos.add(articulo);
		}
		return articulos;
	}
	
	public List<Articulo> listarArticulos(Usuario u) {
		return articuloRepo.findArticulosByUsuario(u);
	}
	
	public void eliminarArticulo(long id) {
		articuloRepo.deleteById(id); 
	}
	
	public List<Articulo> buscarArticulosPorCategoria(Categoria c) {
		return articuloRepo.findArticulosByCategoria(c);
	}
	
	public List<Articulo> buscarArticulosPorUsuario(Usuario u) {
		return articuloRepo.findArticulosByUsuario(u);
	}
	
	public Articulo buscarArticulo(long id) {
		return articuloRepo.findById(id).orElse(null);
	}
	
	public List<Articulo> buscarArticulosPorCreacion(Date creacion) {
		return articuloRepo.findArticulosByCreacion(creacion);
	}
}
