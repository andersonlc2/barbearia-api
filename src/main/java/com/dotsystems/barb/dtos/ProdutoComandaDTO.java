package com.dotsystems.barb.dtos;

import java.io.Serializable;

import com.dotsystems.barb.entities.ProdutoComanda;

public class ProdutoComandaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long comanda;
	private Long produto;
	private Integer quantidade;
	private Double valor;
	private Double subTotal;

	public ProdutoComandaDTO() {

	}

	public ProdutoComandaDTO(ProdutoComanda obj) {
		this.comanda = obj.getComanda().getId();
		this.produto = obj.getProduto().getId();
		this.quantidade = obj.getQuantidade();
		this.valor = obj.getValor();
		this.subTotal = obj.getSubTotal();
	}

	public Long getComanda() {
		return comanda;
	}

	public void setComanda(Long comanda) {
		this.comanda = comanda;
	}

	public Long getProduto() {
		return produto;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
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

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

}
