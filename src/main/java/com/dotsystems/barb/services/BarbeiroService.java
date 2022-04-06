package com.dotsystems.barb.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.BarbeiroDTO;
import com.dotsystems.barb.dtos.BarbeiroInsertDTO;
import com.dotsystems.barb.entities.Barbeiro;
import com.dotsystems.barb.repositories.BarbeiroRepository;
import com.dotsystems.barb.repositories.EquipeRepository;

@Service
public class BarbeiroService {

	@Autowired
	private BarbeiroRepository repository;

	@Autowired
	private EquipeRepository equiRepository;

	@Transactional
	public BarbeiroInsertDTO save(BarbeiroInsertDTO barbeiroDto) {
		var barbeiro = new Barbeiro();
		BeanUtils.copyProperties(barbeiroDto, barbeiro);
		barbeiro.setData_cadastro(new Date());
		barbeiro.setEquipe(equiRepository.findById(barbeiroDto.getEquipe()).get());
		repository.save(barbeiro);
		return new BarbeiroInsertDTO(barbeiro);
	}

	@Transactional
	public BarbeiroInsertDTO update(Long id, BarbeiroInsertDTO obj) {
		Barbeiro barbeiro = repository.findById(id).get();
		barbeiro.setNome(obj.getNome());
		barbeiro.setEmail(obj.getEmail());
		barbeiro.setAtivo(obj.getAtivo());
		barbeiro.setendereco(obj.getEndereco());
		barbeiro.setEquipe(equiRepository.findById(obj.getEquipe()).get());
		barbeiro.setSenha(obj.getSenha());
		repository.save(barbeiro);
		return new BarbeiroInsertDTO(barbeiro);
	}

	@Transactional
	public void delete(Long id) {
		Barbeiro obj = repository.findById(id).get();
		repository.delete(obj);
	}

	public List<BarbeiroDTO> findAll() {
		return repository.findAll().stream().map(x -> new BarbeiroDTO(x)).collect(Collectors.toList());
	}

	public BarbeiroDTO findById(Long id) {
		return new BarbeiroDTO(repository.findById(id).get());
	}

}
