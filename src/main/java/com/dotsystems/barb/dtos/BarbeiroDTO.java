package com.dotsystems.barb.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.dotsystems.barb.entities.Barbeiro;
import com.dotsystems.barb.entities.Equipe;

public class BarbeiroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String endereco;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private Boolean ativo;

	@NotBlank
	private Equipe equipe;

	public BarbeiroDTO() {

	}

	public BarbeiroDTO(Barbeiro obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.endereco = obj.getendereco();
		this.email = obj.getEmail();
		this.ativo = obj.getAtivo();
		this.equipe = obj.getEquipe();
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
}
