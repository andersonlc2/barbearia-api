package com.dotsystems.barb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotsystems.barb.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
