package com.dotsystems.barb.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.dotsystems.barb.entities.Barbeiro;

public class BarbeiroInsertDTO {

	@NotBlank
	private String nome;

	@NotBlank
	private String endereco;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String senha;

	private Boolean ativo;

	private Long equipe;
	
	public BarbeiroInsertDTO() {
		
	}

	public BarbeiroInsertDTO(Barbeiro obj) {
		this.nome = obj.getNome();
		this.endereco = obj.getendereco();
		this.email = obj.getEmail();
		this.senha = obj.getEmail();
		this.ativo = obj.getAtivo();
		this.equipe = obj.getEquipe().getId();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getEquipe() {
		return equipe;
	}

	public void setEquipe(Long equipe) {
		this.equipe = equipe;
	}

}
