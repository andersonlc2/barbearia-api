package com.dotsystems.barb.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_agendamento")
@SequenceGenerator(name = "AGENDAMENTO_SEQ")
public class Agendamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENDAMENTO_SEQ")
	private Long id;

	@OneToOne
	private Comanda comanda;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "horario_id"), @JoinColumn(name = "barb_id") })
	private HorarioBarbeiro horarioBarb;

	@ManyToOne
	@JoinColumn(name = "horario_cliente_id")
	private Cliente cliente;

	public Agendamento() {

	}

	public Agendamento(Long id, Comanda comanda, HorarioBarbeiro horarioBarb, Cliente cliente) {
		this.id = id;
		this.comanda = comanda;
		this.horarioBarb = horarioBarb;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public HorarioBarbeiro getHorarioBarb() {
		return horarioBarb;
	}

	public void setHorarioBarb(HorarioBarbeiro horarioBarb) {
		this.horarioBarb = horarioBarb;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Agendamento other = (Agendamento) obj;
		return Objects.equals(id, other.id);
	}

}
