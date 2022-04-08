package com.dotsystems.barb.dtos;

import java.io.Serializable;

import com.dotsystems.barb.entities.Agendamento;
import com.dotsystems.barb.entities.enums.StatusHorario;

public class AgendamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long horario;
	private Long barbeiro;
	private Long cliente;
	private Long comanda;
	private StatusHorario status;

	public AgendamentoDTO() {

	}

	public AgendamentoDTO(Agendamento obj) {
		this.id = obj.getId();
		this.horario = obj.getHorarioBarb().getHorario().getId();
		this.barbeiro = obj.getHorarioBarb().getBarbeiro().getId();
		this.cliente = obj.getCliente().getId();
		this.comanda = obj.getComanda();
		this.status = obj.getHorarioBarb().getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHorario() {
		return horario;
	}

	public void setHorario(Long horario) {
		this.horario = horario;
	}

	public Long getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Long barbeiro) {
		this.barbeiro = barbeiro;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Long getComanda() {
		return comanda;
	}

	public void setComanda(Long comanda) {
		this.comanda = comanda;
	}

	public StatusHorario getStatus() {
		return status;
	}

	public void setStatus(StatusHorario status) {
		this.status = status;
	}

}
