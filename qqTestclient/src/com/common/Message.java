package com.common;

import java.io.Serializable;

public class Message implements Serializable {
	private String mesType;

	public String getMesType() {
		return mesType;
	}

	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
}
