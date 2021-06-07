package com.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion implements Serializable {
	
	private static long serialVersionUID =1L;
	public static Connection c;
	
	static final String URL = "jdbc:postgresql://queenie.db.elephantsql.com:5432/";
	static final String USER = "mnjgxshj";
	static final String PASS = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	
	
	public static Connection crearconexion() {
		if (c == null) {
			try {
				Class.forName("org.postgresql.Driver");
				c = (Connection) DriverManager.getConnection(URL, USER, PASS);
				System.out.println("Conexion establecida...");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return c;
	}

	public static void close() {
		try {
			c.close();
			c = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Conexion.serialVersionUID = serialVersionUID;
	}

	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		Conexion.c = c;
	}

	
}
