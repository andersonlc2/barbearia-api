package com.dotsystems.barb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.HorarioDTO;
import com.dotsystems.barb.entities.Horario;
import com.dotsystems.barb.repositories.HorarioRepository;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository repository;

	@Transactional
	public HorarioDTO save(HorarioDTO obj) {
		var horario = new Horario();
		BeanUtils.copyProperties(obj, horario);
		repository.save(horario);
		return new HorarioDTO(horario);
	}

	@Transactional
	public HorarioDTO update(Long id, HorarioDTO obj) {
		var horario = repository.findById(id).get();
		horario.setHorario(obj.getHorario());
		repository.save(horario);
		return new HorarioDTO(horario);
	}

	@Transactional
	public Long delete(Long id) {
		var horario = repository.findById(id).get();
		repository.delete(horario);
		return id;
	}

	public List<HorarioDTO> findAll() {
		return repository.findAll().stream().map(x -> new HorarioDTO(x)).collect(Collectors.toList());
	}

	public HorarioDTO findById(Long id) {
		var horario = repository.findById(id).get();
		return new HorarioDTO(horario);
	}

}
