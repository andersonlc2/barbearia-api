package com.dotsystems.barb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.dotsystems.barb.entities.enums.StatusComanda;

@Entity
@Table(name = "tb_comanda")
@SequenceGenerator(name = "COMANDA_SEQ", initialValue = 1, allocationSize = 1)
public class Comanda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMANDA_SEQ")
	private Long id;
	@Column(nullable = false)
	private Long agendamentoId;
	@Column(nullable = false)
	private Date data;
	@Column(nullable = false)
	private Integer status;

	@OneToMany(mappedBy = "id.comanda")
	private Set<ProdutoComanda> produtos = new HashSet<>();

	@OneToMany(mappedBy = "id.comanda")
	private Set<ServicoComanda> servicos = new HashSet<>();

	public Comanda() {

	}

	public Comanda(Long id, Long agendamentoId, Date data, Integer status) {
		this.id = id;
		this.agendamentoId = agendamentoId;
		this.data = data;
		StatusComanda.valueOf(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgendamentoId() {
		return agendamentoId;
	}

	public void setAgendamentoId(Long agendamentoId) {
		this.agendamentoId = agendamentoId;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public StatusComanda getStatus() {
		return StatusComanda.valueOf(status);
	}

	public void setStatus(StatusComanda status) {
		if (status != null) {
			this.status = status.getCode();
		}
	}

	public Set<ProdutoComanda> getProdutos() {
		return produtos;
	}

	public Set<ServicoComanda> getServicos() {
		return servicos;
	}
	
	public Double getTotalComanda() {
		double soma = 0;
		for (ProdutoComanda produto : produtos) {
			soma += produto.getSubTotal();
		}
		for (ServicoComanda servico : servicos) {
			soma += servico.getSubTotal();
		}
		
		return soma;
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
		Comanda other = (Comanda) obj;
		return Objects.equals(id, other.id);
	}

}
