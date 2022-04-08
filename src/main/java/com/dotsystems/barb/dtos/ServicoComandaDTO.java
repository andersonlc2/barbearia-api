package com.dotsystems.barb.dtos;

import java.io.Serializable;

import com.dotsystems.barb.entities.ServicoComanda;

public class ServicoComandaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long comanda;
	private Long servico;
	private Integer quantidade;
	private Double valor;
	private Double subTotal;

	public ServicoComandaDTO() {

	}

	public ServicoComandaDTO(ServicoComanda obj) {
		this.comanda = obj.getComanda().getId();
		this.servico = obj.getServico().getId();
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

	public Long getServico() {
		return servico;
	}

	public void setServico(Long servico) {
		this.servico = servico;
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
