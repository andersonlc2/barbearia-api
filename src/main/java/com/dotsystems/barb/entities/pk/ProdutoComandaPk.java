package com.dotsystems.barb.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dotsystems.barb.entities.Comanda;
import com.dotsystems.barb.entities.Produto;

@Embeddable
public class ProdutoComandaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "comanda_id")
	private Comanda comanda;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comanda, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoComandaPk other = (ProdutoComandaPk) obj;
		return Objects.equals(comanda, other.comanda) && Objects.equals(produto, other.produto);
	}

}
