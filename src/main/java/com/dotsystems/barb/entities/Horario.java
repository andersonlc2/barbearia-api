package com.dotsystems.barb.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_horario")
@SequenceGenerator(name = "HORARIO_SEQ", initialValue = 1, allocationSize = 1)
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HORARIO_SEQ")
	private Long id;

	@Column(nullable = false)
	private Timestamp horario;

	@JsonIgnore
	@OneToMany(mappedBy = "id.horario")
	private Set<HorarioBarbeiro> horarios = new HashSet<>();

	public Horario() {

	}

	public Horario(Long id, Timestamp horario) {
		this.id = id;
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getHorario() {
		return horario;
	}

	public void setHorario(Timestamp horario) {
		this.horario = horario;
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
		Horario other = (Horario) obj;
		return Objects.equals(id, other.id);
	}

}
