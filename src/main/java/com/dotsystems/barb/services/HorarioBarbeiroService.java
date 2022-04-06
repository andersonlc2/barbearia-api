package com.dotsystems.barb.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.HorarioBarbeiroDTO;
import com.dotsystems.barb.entities.HorarioBarbeiro;
import com.dotsystems.barb.entities.enums.StatusHorario;
import com.dotsystems.barb.repositories.BarbeiroRepository;
import com.dotsystems.barb.repositories.HorarioBarbeiroRepository;

@Service
public class HorarioBarbeiroService {

	@Autowired
	private HorarioBarbeiroRepository repository;

	@Autowired
	private BarbeiroRepository barbRepository;

	@Transactional
	public HorarioBarbeiroDTO save(HorarioBarbeiroDTO obj) {
		var horarioBarbeiro = new HorarioBarbeiro();
		BeanUtils.copyProperties(obj, horarioBarbeiro);
		repository.save(horarioBarbeiro);
		return new HorarioBarbeiroDTO(horarioBarbeiro);
	}

	@Transactional
	public HorarioBarbeiroDTO update(Long id, Long id_horario, HorarioBarbeiroDTO obj) {
		Set<HorarioBarbeiro> list = barbRepository.findById(id).get().getHorarios();
		for (HorarioBarbeiro horario : list) {
			if (horario.getHorario().getId() == id_horario) {
				horario.setStatus(StatusHorario.valueOf(obj.getStatus()));
				return new HorarioBarbeiroDTO(horario);
			}
		}
		return null;
	}

	@Transactional
	public void delete(Long id) {
		var horarioBarbeiro = repository.findById(id).get();
		repository.delete(horarioBarbeiro);
	}

	public List<HorarioBarbeiroDTO> findAll() {
		return repository.findAll().stream().map(x -> new HorarioBarbeiroDTO(x)).collect(Collectors.toList());
	}

	public List<HorarioBarbeiroDTO> findByBarbeiro(Long id) {
		Set<HorarioBarbeiro> list = barbRepository.findById(id).get().getHorarios();
		List<HorarioBarbeiroDTO> listDto = list.stream().map(x -> new HorarioBarbeiroDTO(x))
				.collect(Collectors.toList());
		return listDto;
	}

	public HorarioBarbeiroDTO findByBarbeiroHorario(Long id, Long id_horario) {
		Set<HorarioBarbeiro> list = barbRepository.findById(id).get().getHorarios();
		for (HorarioBarbeiro horario : list) {
			if (horario.getHorario().getId() == id_horario) {
				return new HorarioBarbeiroDTO(horario);
			}
		}
		return null;
	}

}
