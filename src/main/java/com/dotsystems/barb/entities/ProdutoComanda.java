package com.dotsystems.barb.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dotsystems.barb.entities.pk.ProdutoComandaPk;

@Entity
@Table(name = "tb_produto_comanda")
public class ProdutoComanda implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdutoComandaPk id = new ProdutoComandaPk();

	private Integer quantidade;
	private Double valor;

	public ProdutoComanda() {

	}

	public ProdutoComanda(Comanda comanda, Produto produto, Integer quantidade, Double valor) {
		id.setComanda(comanda);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Comanda getComanda() {
		return id.getComanda();
	}

	public void setComanda(Comanda comanda) {
		id.setComanda(comanda);
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void SetProduto(Produto produto) {
		id.setProduto(produto);
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoComanda other = (ProdutoComanda) obj;
		return Objects.equals(id, other.id);
	}

}
