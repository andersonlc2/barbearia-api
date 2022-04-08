package com.dotsystems.barb.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.ProdutoComandaDTO;
import com.dotsystems.barb.entities.ProdutoComanda;
import com.dotsystems.barb.repositories.ComandaRepository;
import com.dotsystems.barb.repositories.ProdutoComandaRepository;
import com.dotsystems.barb.repositories.ProdutoRepository;

@Service
public class ProdutoComandaService {

	@Autowired
	private ProdutoComandaRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ComandaRepository comandaRepository;

	@Transactional
	public ProdutoComandaDTO save(ProdutoComandaDTO obj) {
		var produto = new ProdutoComanda();
		produto.setComanda(comandaRepository.findById(obj.getComanda()).get());
		produto.setProduto(produtoRepository.findById(obj.getProduto()).get());
		BeanUtils.copyProperties(obj, produto);
		repository.save(produto);
		return new ProdutoComandaDTO(produto);
	}
	
	@Transactional
	public ProdutoComandaDTO save(Long id_comanda, ProdutoComandaDTO obj) {
		var produto = new ProdutoComanda();
		produto.setComanda(comandaRepository.findById(id_comanda).get());
		produto.setProduto(produtoRepository.findById(obj.getProduto()).get());
		BeanUtils.copyProperties(obj, produto);
		repository.save(produto);
		return new ProdutoComandaDTO(produto);
	}

	@Transactional
	public ProdutoComandaDTO update(Long id_comanda, Long id, ProdutoComandaDTO obj) {
		var produtoList = comandaRepository.findById(id_comanda).get();
		for (ProdutoComanda produto : produtoList.getProdutos()) {
			if (produto.getProduto().getId() == id) {
				produto.setQuantidade(obj.getQuantidade());
				produto.setValor(obj.getValor());
				repository.save(produto);
				return new ProdutoComandaDTO(produto);

			}
		}

		return null;
	}
	
	@Transactional
	public ProdutoComandaDTO update(Long id_comanda, ProdutoComandaDTO obj) {
		var produtoList = comandaRepository.findById(id_comanda).get();
		for (ProdutoComanda produto : produtoList.getProdutos()) {
			if (produto.getProduto().getId() == obj.getProduto()) {
				produto.setQuantidade(obj.getQuantidade());
				produto.setValor(obj.getValor());
				repository.save(produto);
				return new ProdutoComandaDTO(produto);

			}
		}

		return null;
	}

	@Transactional
	public void delete(Long id_comanda, Long id) {
		var listProdutos = comandaRepository.findById(id_comanda).get().getProdutos();
		for (ProdutoComanda produto : listProdutos) {
			if (produto.getProduto().getId() == id) {
				repository.delete(produto);				
			}
		}
	}

	public List<ProdutoComandaDTO> findAll() {
		return repository.findAll().stream().map(x -> new ProdutoComandaDTO(x)).collect(Collectors.toList());
	}

	public List<ProdutoComandaDTO> findByComanda(Long id) {
		Set<ProdutoComanda> list = comandaRepository.findById(id).get().getProdutos();
		List<ProdutoComandaDTO> listDto = list.stream().map(x -> new ProdutoComandaDTO(x)).collect(Collectors.toList());
		return listDto;
	}

	public ProdutoComandaDTO findByProdutoComanda(Long id, Long id_produto) {
		Set<ProdutoComanda> list = comandaRepository.findById(id).get().getProdutos();
		for (ProdutoComanda produto : list) {
			if (produto.getProduto().getId() == id_produto) {
				return new ProdutoComandaDTO(produto);
			}
		}
		return null;
	}

}
