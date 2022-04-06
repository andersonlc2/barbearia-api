package com.dotsystems.barb.dtos;

import com.dotsystems.barb.entities.Horario;
import com.dotsystems.barb.entities.HorarioBarbeiro;

public class HorarioBarbeiroDTO {

	private Horario horario;
	private Integer status;

	public HorarioBarbeiroDTO() {

	}

	public HorarioBarbeiroDTO(HorarioBarbeiro obj) {

		this.horario = obj.getHorario();
		this.status = obj.getStatus().getCode();
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
