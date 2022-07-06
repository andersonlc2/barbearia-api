package com.dotsystems.barb.dtos;

import java.io.Serializable;
import java.util.Date;

import com.dotsystems.barb.entities.Comanda;

public class ComandaSaveDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date data;
	private Integer status;

	public ComandaSaveDTO() {

	}

	public ComandaSaveDTO(Comanda obj) {
		this.data = obj.getData();
		this.status = obj.getStatus().getCode();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
