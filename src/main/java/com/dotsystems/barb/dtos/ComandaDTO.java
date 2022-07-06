package com.dotsystems.barb.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.dotsystems.barb.entities.Comanda;
import com.dotsystems.barb.entities.ProdutoComanda;
import com.dotsystems.barb.entities.ServicoComanda;

public class ComandaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date data;
	private Integer status;
	private Double total;

	private Set<ProdutoComanda> produtos;

	private Set<ServicoComanda> servicos;

	public ComandaDTO() {

	}

	public ComandaDTO(Comanda obj) {
		this.id = obj.getId();
		this.data = obj.getData();
		this.status = obj.getStatus().getCode();
		this.produtos = obj.getProdutos();
		this.servicos = obj.getServicos();
		this.total = obj.getTotalComanda();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<ProdutoComanda> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutoComanda> produtos) {
		this.produtos = produtos;
	}

	public Set<ServicoComanda> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicoComanda> servicos) {
		this.servicos = servicos;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
