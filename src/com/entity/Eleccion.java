package com.entity;

import java.io.Serializable;

public class Eleccion implements Serializable {

	private int id;
	private String nombre, f_inicio, f_fin, cargo;
	private static final long serialVersionUID = 1L;

    public Eleccion() {
		super();
	}

	public Eleccion(int id, String nombre, String f_inicio, String f_fin, String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.f_inicio = f_inicio;
		this.f_fin = f_fin;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(String f_inicio) {
		this.f_inicio = f_inicio;
	}

	public String getF_fin() {
		return f_fin;
	}

	public void setF_fin(String f_fin) {
		this.f_fin = f_fin;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    
	
}
