package com.dotsystems.barb.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dotsystems.barb.entities.Barbeiro;
import com.dotsystems.barb.entities.Horario;

@Embeddable
public class StatusPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "barbeiro_id")
	private Barbeiro barbeiro;

	@ManyToOne
	@JoinColumn(name = "horario_id")
	private Horario horario;

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barbeiro, horario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusPk other = (StatusPk) obj;
		return Objects.equals(barbeiro, other.barbeiro) && Objects.equals(horario, other.horario);
	}

}
