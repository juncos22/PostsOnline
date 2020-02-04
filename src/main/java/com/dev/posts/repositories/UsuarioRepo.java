package com.dev.posts.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.posts.entities.Usuario;

@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, Long> {
	Optional<Usuario> findByNombre(String nombre);
}
