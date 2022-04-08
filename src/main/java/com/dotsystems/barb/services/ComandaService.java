package com.dotsystems.barb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.ComandaDTO;
import com.dotsystems.barb.entities.Comanda;
import com.dotsystems.barb.entities.enums.StatusComanda;
import com.dotsystems.barb.repositories.ComandaRepository;

@Service
public class ComandaService {

	@Autowired
	private ComandaRepository repository;

	@Transactional
	public ComandaDTO save(ComandaDTO obj) {
		var comanda = new Comanda();
		comanda.setStatus(StatusComanda.valueOf(obj.getStatus()));
		BeanUtils.copyProperties(obj, comanda);
		repository.save(comanda);
		return new ComandaDTO(comanda);
	}

	@Transactional
	public ComandaDTO update(Long id, ComandaDTO obj) {
		var comanda = repository.findById(id).get();
		comanda.setData(obj.getData());
		comanda.setAgendamentoId(obj.getAgendamentoId());
		comanda.setData(obj.getData());
		comanda.setStatus(StatusComanda.valueOf(obj.getStatus()));
		return new ComandaDTO(comanda);
	}

	@Transactional
	public void delete(Long id) {
		var comanda = repository.findById(id).get();
		repository.delete(comanda);
	}

	public List<ComandaDTO> findAll() {
		return repository.findAll().stream().map(x -> new ComandaDTO(x)).collect(Collectors.toList());
	}

	public ComandaDTO findById(Long id) {
		return new ComandaDTO(repository.findById(id).get());
	}

}
