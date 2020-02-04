package com.dev.posts.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.posts.entities.Categoria;

@Repository
public interface CategoriaRepo extends CrudRepository<Categoria, Long> {

}
