package com.dotsystems.barb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.CategoriaDTO;
import com.dotsystems.barb.entities.Categoria;
import com.dotsystems.barb.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Transactional
	public CategoriaDTO save(CategoriaDTO obj) {
		var categoria = new Categoria();
		BeanUtils.copyProperties(obj, categoria);
		repository.save(categoria);
		return new CategoriaDTO(categoria);
	}

	@Transactional
	public CategoriaDTO update(Long id, CategoriaDTO obj) {
		var categoria = repository.findById(id).get();
		categoria.setNome(obj.getNome());
		return new CategoriaDTO(categoria);
	}

	@Transactional
	public void delete(Long id) {
		var categoria = repository.findById(id).get();
		repository.delete(categoria);
	}

	public List<CategoriaDTO> findAll() {
		return repository.findAll().stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());
	}

	public CategoriaDTO findById(Long id) {
		return new CategoriaDTO(repository.findById(id).get());
	}

}
