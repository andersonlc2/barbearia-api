package com.dotsystems.barb.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dotsystems.barb.entities.enums.StatusHorario;
import com.dotsystems.barb.entities.pk.StatusPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_horario_barbeiro")
public class HorarioBarbeiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StatusPk id = new StatusPk();

	private Integer status;

	public HorarioBarbeiro() {

	}

	public HorarioBarbeiro(Barbeiro barbeiro, Horario horario, StatusHorario status) {
		id.setBarbeiro(barbeiro);
		id.setHorario(horario);
		setStatus(status);
	}

	public StatusHorario getStatus() {
		return StatusHorario.valueOf(status);
	}

	public void setStatus(StatusHorario status) {
		if (status != null) {
			this.status = status.getCode();
		}
	}

	@JsonIgnore
	public Barbeiro getBarbeiro() {
		return id.getBarbeiro();
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		id.setBarbeiro(barbeiro);
	}

	public Horario getHorario() {
		return id.getHorario();
	}

	public void setHorario(Horario horario) {
		id.setHorario(horario);
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
		HorarioBarbeiro other = (HorarioBarbeiro) obj;
		return Objects.equals(id, other.id);
	}

}
