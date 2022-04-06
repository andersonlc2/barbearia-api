package com.dotsystems.barb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.EquipeDTO;
import com.dotsystems.barb.entities.Equipe;
import com.dotsystems.barb.repositories.EquipeRepository;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository repository;

	@Transactional
	public EquipeDTO save(EquipeDTO obj) {
		var equipe = new Equipe();
		BeanUtils.copyProperties(obj, equipe);
		repository.save(equipe);
		return new EquipeDTO(equipe);
	}

	@Transactional
	public EquipeDTO update(Long id, EquipeDTO obj) {
		var equipe = repository.findById(id).get();
		equipe.setLider(obj.getLider());
		equipe.setNome(obj.getNome());
		return new EquipeDTO(equipe);
	}

	@Transactional
	public void delete(Long id) {
		var equipe = repository.findById(id).get();
		repository.delete(equipe);
	}

	public List<EquipeDTO> findAll() {
		return repository.findAll().stream().map(x -> new EquipeDTO(x)).collect(Collectors.toList());
	}

	public EquipeDTO findById(Long id) {
		return new EquipeDTO(repository.findById(id).get());
	}

}
