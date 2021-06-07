package com.DAO;

import java.util.List;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Candidato;
import com.util.Conexion;
import com.util.QueryGeneric;

public class CandidatoDAO implements Serializable {
	
private static final long serialVersionUID =1L;
private QueryGeneric<Candidato> query;

public List<Candidato> list() {
	this.query = new QueryGeneric<Candidato>();
	
	this.query.setQuery("SELECT * FROM candidato");
	
	this.query.setList(new ArrayList<Candidato>());
	
	try 
	{
		
		this.query.setPs(Conexion.getC().prepareStatement(this.query.getQuery()));
		this.query.setRs(this.query.getPs().executeQuery());
		
		while (this.query.getRs().next()) 
		{
			this.query.setEntity(new Candidato());
			this.query.getEntity().setId(this.query.getRs().getInt(1));
			this.query.getEntity().setEleccion(this.query.getRs().getInt(2));
			this.query.getEntity().setNumero(this.query.getRs().getInt(3));
			this.query.getEntity().setNombre(this.query.getRs().getString(4));
			this.query.getEntity().setApellido(this.query.getRs().getString(5));
			this.query.getEntity().setDocumento(this.query.getRs().getString(6));
			this.query.getList().add(this.query.getEntity());
		}
	} 
	
	catch (SQLException e) 
	{
		System.out.println(e.getMessage());
	} 
	return this.query.getList();
}

public List<Candidato> list(String id) {
	
	this.query = new QueryGeneric<Candidato>();
	
	this.query.setQuery("SELECT * FROM candidato WHERE eleccion = "+id);
	
	this.query.setList(new ArrayList<Candidato>());
	
	try
	{
		this.query.setPs(Conexion.getC().prepareStatement(this.query.getQuery()));
		this.query.setRs(this.query.getPs().executeQuery());
		
		while (this.query.getRs().next()) 
		{
			this.query.setEntity(new Candidato());
			this.query.getEntity().setId(this.query.getRs().getInt(1));
			this.query.getEntity().setEleccion(this.query.getRs().getInt(2));
			this.query.getEntity().setNumero(this.query.getRs().getInt(3));
			this.query.getEntity().setNombre(this.query.getRs().getString(4));
			this.query.getEntity().setApellido(this.query.getRs().getString(5));
			this.query.getEntity().setDocumento(this.query.getRs().getString(6));
			this.query.getList().add(this.query.getEntity());
		}
	} 
	catch (SQLException e) 
	{
		System.out.println(e.getMessage());
	} 
	return this.query.getList();
}

public Candidato find(String id){
	
	this.query = new QueryGeneric<Candidato>();
	
	this.query.setQuery("SELECT * FROM candidato WHERE id = "+id);
	
	try 
	{
		this.query.setPs(Conexion.getC().prepareStatement(this.query.getQuery()));
		this.query.setRs(this.query.getPs().executeQuery());
		
		while (this.query.getRs().next()) 
		{
			this.query.setEntity(new Candidato());
			this.query.getEntity().setId(this.query.getRs().getInt(1));
			this.query.getEntity().setEleccion(this.query.getRs().getInt(2));
			this.query.getEntity().setNumero(this.query.getRs().getInt(3));
			this.query.getEntity().setNombre(this.query.getRs().getString(4));
			this.query.getEntity().setApellido(this.query.getRs().getString(5));
			this.query.getEntity().setDocumento(this.query.getRs().getString(6));
		}
	} 
	
	catch (SQLException e)
	{
		System.out.println(e.getMessage());
	} 
	return this.query.getEntity();
}




public void insert(Candidato t) {
	if (t != null) {
		this.query = new QueryGeneric<Candidato>();
		
		this.query.setQuery(
				"INSERT INTO candidato(id,eleccion,numero,nombre,apellido,documento) VALUES (?,?,?,?,?,?)");
		try 
		{
			this.query.setPs(Conexion.getC().prepareStatement(this.query.getQuery()));
			this.query.getPs().setInt(1, t.getId());
			this.query.getPs().setInt(2, t.getEleccion());
			this.query.getPs().setInt(3, t.getNumero());
			this.query.getPs().setString(4, t.getNombre());
			this.query.getPs().setString(5, t.getApellido());
			this.query.getPs().setString(6, t.getDocumento());
			
			this.query.getPs().executeUpdate();
		}
            catch (SQLException e)
		         {
			          System.out.println(e.getMessage());
		         } 
	}
}

public void update(Candidato t) {
	if (t != null) {
		this.query = new QueryGeneric<Candidato>();
		this.query.setQuery(
				"UPDATE candidato SET eleccion = ?, numero = ?, nombre = ?, apellido = ?,documento = ?  , WHERE id = "+ t.getId() + "");
		try 
		{
			this.query.setPs(Conexion.getC().prepareStatement(this.query.getQuery()));
			this.query.getPs().setInt(1, t.getEleccion());
			this.query.getPs().setInt(2, t.getNumero());
			this.query.getPs().setString(3, t.getNombre());
			this.query.getPs().setString(4, t.getApellido());
			this.query.getPs().setString(5, t.getDocumento());
			
			this.query.getPs().executeUpdate();
		} 
		
		catch (SQLException e) 
		
		{
			System.out.println(e.getMessage());
		} 
	}
}

public boolean delete(int id) {
	
	if (id > 0) {
		
		this.query = new QueryGeneric<Candidato>();
		query.setQuery("DELETE FROM candidato WHERE id = " + id + "");
		
		try 
		{
			this.query.setPs(Conexion.getC().prepareStatement(this.query.getQuery()));
			if (this.query.getPs().executeUpdate() > 0) 
			
			{
				return true;
			}
		} 
		
		catch (SQLException e)
		
		{
			System.out.println(e.getMessage());
		} 
	}
	return false;
}



}