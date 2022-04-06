package com.dotsystems.barb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.ProdutoDTO;
import com.dotsystems.barb.entities.Produto;
import com.dotsystems.barb.entities.enums.CategoriaProduto;
import com.dotsystems.barb.repositories.FornecedorRepository;
import com.dotsystems.barb.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Transactional
	public ProdutoDTO save(ProdutoDTO obj) {
		var produto = new Produto();
		produto.setFornecedor(fornecedorRepository.getById(obj.getFornecedor()));
		produto.setCategoria(CategoriaProduto.valueOf(obj.getCategoria()));
		BeanUtils.copyProperties(obj, produto);
		repository.save(produto);
		return new ProdutoDTO(produto);
	}

	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO obj) {
		var produto = repository.findById(id).get();
		produto.setNome(obj.getNome());
		produto.setFornecedor(fornecedorRepository.getById(obj.getFornecedor()));
		produto.setCategoria(CategoriaProduto.valueOf(obj.getCategoria()));
		return new ProdutoDTO(produto);
	}

	@Transactional
	public void delete(Long id) {
		var produto = repository.findById(id).get();
		repository.delete(produto);
	}

	public List<ProdutoDTO> findAll() {
		return repository.findAll().stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
	}

	public ProdutoDTO findById(Long id) {
		return new ProdutoDTO(repository.findById(id).get());
	}

}
