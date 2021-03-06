package com.dotsystems.barb.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

import com.dotsystems.barb.entities.Horario;

public class HorarioDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Timestamp horario;

	public HorarioDTO() {

	}

	public HorarioDTO(Horario obj) {
		this.id = obj.getId();
		this.horario = obj.getHorario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getHorario() {
		return horario;
	}

	public void setHorario(Timestamp horario) {
		this.horario = horario;
	}

}
