package com.entity;

import java.io.Serializable;

public class votante implements Serializable {

	private int id,tipo_documento, eleccion;
	private String nombre, documento,email;

	public votante() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(int tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public int getEleccion() {
		return eleccion;
	}

	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
