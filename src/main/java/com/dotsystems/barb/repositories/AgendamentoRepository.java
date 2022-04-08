package com.dotsystems.barb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotsystems.barb.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
