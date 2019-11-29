package ejemplobasesdedatos;

import java.sql.SQLException;
import java.sql.Statement;

public class guardardatos {
	public void guardar(Usuario u) throws BDException{
		try(Statement stmt = conn.createStatement()){
			String sql = "INSERT INTO usuario (id, nombre, apellido) VALUES (" + u.getid() + ", " + u.getnombre() + ", " + u.getapellido( + "')";
			stmt.executeUpdate(sql);
		}catch (SQLException e) {
			throw new BDException("error al obtener el usuario",e);
		}
	}
	
	public class guardardatos1 {
		public void guardar(Usuario u) throws BDException{
			String sql = "INSERT INTO usuario (id, nombre, apellido) VALUES (?,?,?)";
			try(Statement stmt = conn.prepareStatement()){
				stmt.setInt(1, u.getid());
				stmt.setString(2, u.getnombre());
				stmt.setString(3, u.getapellido());
				
				stmt.executeUpdate();
			}catch (SQLException e) {
				throw new BDException("error al obtener el usuario",e);
			}
		}
	}
}
