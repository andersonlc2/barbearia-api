package com.dotsystems.barb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotsystems.barb.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
