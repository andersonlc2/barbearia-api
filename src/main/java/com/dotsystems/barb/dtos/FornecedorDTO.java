package com.dotsystems.barb.dtos;

import javax.validation.constraints.NotBlank;

import com.dotsystems.barb.entities.Fornecedor;

public class FornecedorDTO {

	
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String cnpj;
	@NotBlank
	private String telefone;
	@NotBlank
	private String endereco;

	public FornecedorDTO() {

	}

	public FornecedorDTO(Fornecedor obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
