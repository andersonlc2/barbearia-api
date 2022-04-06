package com.dotsystems.barb.entities.enums;

public enum StatusComanda {
	
	FECHADA(1),
	PAGA(2),
	ABERTA(3),
	BLOQUEADA(4);
	
	private int code;
	
	private StatusComanda(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusComanda valueOf(int code) {
		for (StatusComanda value : StatusComanda.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Status inválido!");
	}
}
