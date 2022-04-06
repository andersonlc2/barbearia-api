package com.dotsystems.barb.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.ClienteDTO;
import com.dotsystems.barb.dtos.ClienteInsertDTO;
import com.dotsystems.barb.entities.Cliente;
import com.dotsystems.barb.repositories.CategoriaRepository;
import com.dotsystems.barb.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CategoriaRepository catRepository;

	@Transactional
	public ClienteInsertDTO save(ClienteInsertDTO obj) {
		var cliente = new Cliente();
		cliente.setData_cadastro(new Date());
		cliente.setCategoria(catRepository.findById(obj.getCategoria()).get());
		BeanUtils.copyProperties(obj, cliente);
		repository.save(cliente);
		return new ClienteInsertDTO(cliente);
	}

	@Transactional
	public ClienteInsertDTO update(Long id, ClienteInsertDTO obj) {
		var cliente = repository.findById(id).get();
		cliente.setNome(obj.getNome());
		cliente.setEmail(obj.getEmail());
		cliente.setSenha(obj.getSenha());
		cliente.setCategoria(catRepository.findById(obj.getCategoria()).get());
		cliente.setTelefone(obj.getTelefone());
		return new ClienteInsertDTO(cliente);
	}

	@Transactional
	public void delete(Long id) {
		var cliente = repository.findById(id).get();
		repository.delete(cliente);
	}

	public List<ClienteDTO> findAll() {
		return repository.findAll().stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
	}

	public ClienteDTO findById(Long id) {
		return new ClienteDTO(repository.findById(id).get());
	}

}
