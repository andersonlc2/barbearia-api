package com.dotsystems.barb.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.AgendamentoDTO;
import com.dotsystems.barb.entities.Agendamento;
import com.dotsystems.barb.entities.HorarioBarbeiro;
import com.dotsystems.barb.repositories.AgendamentoRepository;
import com.dotsystems.barb.repositories.BarbeiroRepository;
import com.dotsystems.barb.repositories.ClienteRepository;
import com.dotsystems.barb.repositories.ComandaRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;

	@Autowired
	private BarbeiroRepository barbRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComandaRepository comandaRepository;

	public AgendamentoDTO save(AgendamentoDTO obj) {
		var agendamento = new Agendamento();
		Set<HorarioBarbeiro> listBarb = barbRepository.findById(obj.getBarbeiro()).get().getHorarios();
		HorarioBarbeiro hor = new HorarioBarbeiro();
		for (HorarioBarbeiro horario : listBarb) {
			if (horario.getHorario().getId() == obj.getHorario()) {
				hor = horario;
			}
		}
		agendamento.setHorarioBarb(hor);
		agendamento.setCliente(clienteRepository.findById(obj.getCliente()).get());
		agendamento.setComanda(comandaRepository.findById(obj.getComanda()).get());

		if (hor.getStatus().getCode() == 3) {
			repository.save(agendamento);
			return new AgendamentoDTO(agendamento);
		} else {
			throw new IllegalArgumentException("Esse horário não está disponível!");
		}

	}

	public List<AgendamentoDTO> findAll() {
		return repository.findAll().stream().map(x -> new AgendamentoDTO(x)).collect(Collectors.toList());
	}
	
	public AgendamentoDTO findById(Long id) {
		return new AgendamentoDTO(repository.findById(id).get());
	}

}
