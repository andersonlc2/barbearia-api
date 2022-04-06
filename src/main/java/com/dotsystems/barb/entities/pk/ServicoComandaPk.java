package com.dotsystems.barb.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dotsystems.barb.entities.Comanda;
import com.dotsystems.barb.entities.Servico;

@Embeddable
public class ServicoComandaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "comanda_id")
	private Comanda comanda;

	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comanda, servico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoComandaPk other = (ServicoComandaPk) obj;
		return Objects.equals(comanda, other.comanda) && Objects.equals(servico, other.servico);
	}

}
