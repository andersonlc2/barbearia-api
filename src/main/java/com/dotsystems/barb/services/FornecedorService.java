package com.dotsystems.barb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.FornecedorDTO;
import com.dotsystems.barb.entities.Fornecedor;
import com.dotsystems.barb.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;

	@Transactional
	public FornecedorDTO save(FornecedorDTO obj) {
		var fornecedor = new Fornecedor();
		BeanUtils.copyProperties(obj, fornecedor);
		repository.save(fornecedor);
		return new FornecedorDTO(fornecedor);
	}

	@Transactional
	public FornecedorDTO update(Long id, FornecedorDTO obj) {
		var fornecedor = repository.findById(id).get();
		fornecedor.setNome(obj.getNome());
		fornecedor.setCnpj(obj.getCnpj());
		fornecedor.setEndereco(obj.getEndereco());
		fornecedor.setTelefone(obj.getTelefone());
		return new FornecedorDTO(fornecedor);
	}

	@Transactional
	public void delete(Long id) {
		var fornecedor = repository.findById(id).get();
		repository.delete(fornecedor);
	}

	public List<FornecedorDTO> findAll() {
		return repository.findAll().stream().map(x -> new FornecedorDTO(x)).collect(Collectors.toList());
	}

	public FornecedorDTO findById(Long id) {
		return new FornecedorDTO(repository.findById(id).get());
	}

}
