package com.dotsystems.barb.dtos;

import javax.validation.constraints.NotBlank;

import com.dotsystems.barb.entities.Categoria;

public class CategoriaDTO {

	private Long id;
	@NotBlank
	private String nome;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
