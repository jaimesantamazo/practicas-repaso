import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion2 {
	
	public static Connection getConexion() {
		 Connection con = null;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bd_pagina";
			String usuario = "root";
			String contrase�a = "root";
			
			con = DriverManager.getConnection(url, usuario, contrase�a);
			
		} catch (ClassNotFoundException e) {
			System.out.println("error al cargar el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error con la BD");
			e.printStackTrace();
		}
		return con;
	}
	
	
	

}
