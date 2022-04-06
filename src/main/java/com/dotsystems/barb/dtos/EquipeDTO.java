package com.dotsystems.barb.dtos;

import javax.validation.constraints.NotBlank;

import com.dotsystems.barb.entities.Equipe;

public class EquipeDTO {

	private Long id;
	private String nome;
	@NotBlank
	private String lider;

	public EquipeDTO() {

	}

	public EquipeDTO(Equipe obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.lider = obj.getLider();
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

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

}
