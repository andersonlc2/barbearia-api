package com.dotsystems.barb.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.dotsystems.barb.entities.Servico;

public class ServicoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank
	private String descricao;
	@NotNull
	private Double valor;
	@NotNull
	private Integer duracaoMin;

	public ServicoDTO() {

	}

	public ServicoDTO(Servico obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.valor = obj.getValor();
		this.duracaoMin = obj.getDuracao() / 5;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getDuracao() {
		return duracaoMin;
	}

	public void setDuracao(Integer duracao) {
		this.duracaoMin = duracao;
	}

}
