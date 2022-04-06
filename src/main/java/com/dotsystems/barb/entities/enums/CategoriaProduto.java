package com.dotsystems.barb.entities.enums;

public enum CategoriaProduto {
	
	BEBIDAS(1),
	COSMETICOS(2),
	EQUIPAMENTOS(3),
	ALIMENTICIOS(4);
	
	private int code;
	
	private CategoriaProduto(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static CategoriaProduto valueOf(int code) {
		for (CategoriaProduto value : CategoriaProduto.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Categoria de produto inválido!");
	}
}
