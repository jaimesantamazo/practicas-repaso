package ejemplobasesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ejemplo {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/internac.ini");
			Statement stmt = conn.createStatement();
			//conexion abierta
			//statement creado
			ResultSet rs = stmt.executeQuery("SELECT nombre, apellido FROM usuario");
			while(rs.next()) {
				//estoy en una fila del resultado
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				
				System.out.println("nombre: "+nombre + "apellido: " + apellido);
				
			}
			
			//ya no queremos usarlos mas
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("no se ha podido cargar el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no se ha podido conectar con la BD");
			e.printStackTrace();
		}

	}

}
