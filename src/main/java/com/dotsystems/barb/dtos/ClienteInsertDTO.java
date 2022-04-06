package com.dotsystems.barb.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.dotsystems.barb.entities.Cliente;

public class ClienteInsertDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;

	@NotBlank
	private String telefone;

	private Date data_cadastro;
	@Email
	private String email;

	private String senha;

	private Long categoria;

	public ClienteInsertDTO() {

	}

	public ClienteInsertDTO(Cliente obj) {
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
		this.data_cadastro = obj.getData_cadastro();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.categoria = obj.getCategoria().getId();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

}
