package com.dotsystems.barb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotsystems.barb.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
