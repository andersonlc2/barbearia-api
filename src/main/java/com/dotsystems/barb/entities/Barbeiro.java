package com.dotsystems.barb.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_barbeiro")
@SequenceGenerator(name = "BARBEIRO_SEQ", initialValue = 10000, allocationSize = 1)
public class Barbeiro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BARBEIRO_SEQ")
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Date data_cadastro;
	@Column(nullable = false)
	private String endereco;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name = "equipe_id")
	private Equipe equipe;

	@JsonIgnore
	@OneToMany(mappedBy = "id.barbeiro")
	private Set<HorarioBarbeiro> horarios = new HashSet<>();

	public Barbeiro() {

	}

	public Barbeiro(Long id, String nome, Date data_cadastro, String endereco, String email, String senha,
			Boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.data_cadastro = data_cadastro;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
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

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getendereco() {
		return endereco;
	}

	public void setendereco(String endereco) {
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@JsonIgnore
	public Set<HorarioBarbeiro> getHorarios() {
		return horarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barbeiro other = (Barbeiro) obj;
		return Objects.equals(id, other.id);
	}

}
