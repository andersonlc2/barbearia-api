package com.dotsystems.barb.entities.enums;

public enum StatusHorario {
	
	RESERVADO(1),
	CANCELADO(2),
	DISPONIVEL(3),
	PESSOAL(4);
	
	private int code;
	
	private StatusHorario(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusHorario valueOf(int code) {
		for (StatusHorario value : StatusHorario.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Status inválido!");
	}
}
