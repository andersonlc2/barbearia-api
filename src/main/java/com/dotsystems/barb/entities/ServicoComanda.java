package com.dotsystems.barb.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dotsystems.barb.entities.pk.ServicoComandaPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_servico_comanda")
public class ServicoComanda implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ServicoComandaPk id = new ServicoComandaPk();

	private Integer quantidade;
	private Double valor;

	public ServicoComanda() {

	}

	public ServicoComanda(Comanda comanda, Servico servico, Integer quantidade, Double valor) {
		id.setComanda(comanda);
		id.setServico(servico);
		this.quantidade = quantidade;
		this.valor = valor;
	}

	@JsonIgnore
	public Comanda getComanda() {
		return id.getComanda();
	}

	public void setComanda(Comanda comanda) {
		id.setComanda(comanda);
	}

	public Servico getServico() {
		return id.getServico();
	}

	public void setServico(Servico servico) {
		id.setServico(servico);
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
		return quantidade * valor;
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
		ServicoComanda other = (ServicoComanda) obj;
		return Objects.equals(id, other.id);
	}

}
