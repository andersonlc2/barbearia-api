package com.dotsystems.barb.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.dotsystems.barb.entities.Produto;

public class ProdutoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank
	private String nome;
	
	private Integer quantidade;

	private Double valor;

	private Long fornecedor;

	private Integer categoria;
	

	public ProdutoDTO() {

	}

	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.quantidade = obj.getQuantidade();
		this.valor = obj.getValor();
		this.fornecedor = obj.getFornecedor().getId();
		this.categoria = obj.getCategoria().getCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	

	public Long getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Long fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}


}
