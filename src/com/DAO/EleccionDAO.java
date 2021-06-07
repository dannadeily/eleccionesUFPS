package com.DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Eleccion;
import com.util.Conexion;
import com.util.QueryGeneric;


public class EleccionDAO implements Serializable {

	private static final long serialVersionUID =1L;
	
	private QueryGeneric<Eleccion> query;
	

	public List<Eleccion> list() {
		
		
	this.query = new QueryGeneric<Eleccion>();
		
		this.query.setQuery("SELECT * FROM eleccion");
		
		this.query.setList(new ArrayList<Eleccion>());
		try
		
		{
			this.query.setPs(Conexion.getC().prepareStatement(this.query.getQuery()));
			this.query.setRs(this.query.getPs().executeQuery());
			
			while (this.query.getRs().next()) 
			{
				this.query.setEntity(new Eleccion());
				this.query.getEntity().setId(this.query.getRs().getInt(1));
				this.query.getEntity().setNombre(this.query.getRs().getString(2));
				this.query.getEntity().setF_inicio(this.query.getRs().getString(3));
				this.query.getEntity().setF_fin(this.query.getRs().getString(4));
				this.query.getEntity().setCargo(this.query.getRs().getString(5));
				this.query.getList().add(this.query.getEntity());
			}
		}
		
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		} 
		return this.query.getList();
	}
}

