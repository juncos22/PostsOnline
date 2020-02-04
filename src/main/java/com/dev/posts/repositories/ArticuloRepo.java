package com.dev.posts.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.posts.entities.Articulo;
import com.dev.posts.entities.Categoria;
import com.dev.posts.entities.Usuario;

@Repository
public interface ArticuloRepo extends CrudRepository<Articulo, Long> {
	List<Articulo> findArticulosByUsuario(Usuario u);
	List<Articulo> findArticulosByCategoria(Categoria c);
	List<Articulo> findArticulosByCreacion(Date creacion);
}
