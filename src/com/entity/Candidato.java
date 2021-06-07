package com.entity;

import java.io.Serializable;

public class Candidato implements Serializable {
	
private int id,eleccion,numero;
private String nombre,apellido,documento;
private static final long serialVersionUID = 1L;




public Candidato() {
}


public Candidato(int id, int eleccion, int numero, String nombre, String apellido, String documento) {
	super();
	this.id = id;
	this.eleccion = eleccion;
	this.numero = numero;
	this.nombre = nombre;
	this.apellido = apellido;
	this.documento = documento;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getEleccion() {
	return eleccion;
}


public void setEleccion(int eleccion) {
	this.eleccion = eleccion;
}


public int getNumero() {
	return numero;
}


public void setNumero(int numero) {
	this.numero = numero;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getApellido() {
	return apellido;
}


public void setApellido(String apellido) {
	this.apellido = apellido;
}


public String getDocumento() {
	return documento;
}


public void setDocumento(String documento) {
	this.documento = documento;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}




}
