package com.dev.posts.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.posts.entities.Rol;

@Repository
public interface RolRepo extends CrudRepository<Rol, Long> {
	Rol findRolByTipo(String tipo);
}
