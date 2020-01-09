import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class conexion {
	
	public static final String controlador = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/bd_pagina";
	public static final String usuario = "root";
	public static final String contrase�a = "root";
	
	static {
		try {
			Class.forName(controlador);
		}catch (ClassNotFoundException e) {
			System.out.println("error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL,usuario,contrase�a);
			
			System.out.println("conexion hecha");
		
		} catch (SQLException e) {
			System.out.println("error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}

}
