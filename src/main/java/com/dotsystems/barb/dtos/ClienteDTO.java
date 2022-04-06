package com.dotsystems.barb.dtos;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.dotsystems.barb.entities.Cliente;

public class ClienteDTO {

	@NotBlank
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;

	private Date data_cadastro;
	@Email
	private String email;

	private Long categoria;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
		this.data_cadastro = obj.getData_cadastro();
		this.email = obj.getEmail();
		this.categoria = obj.getCategoria().getId();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

}
