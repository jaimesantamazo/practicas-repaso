package ejemplobasesdedatos;

import java.sql.ResultSet;
import java.sql.Statement;

public class obtenerusuario {
	public List<usuario> obtenerusuario(String nombre, String apellido) throws BDException{
		List<usuario> usuarios = new ArrayList<usuario>();
		try(Statement stmt = conn.createStatment()){
			String sql = "SELECT id,nombre,apellido FROM usuario WHERE apellido='" + apellido + "' AND nombre='" + nombre + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usuario u = new usuario();
				u.setid(rs.getInt("id"));
				u.setnombre(rs.getString("nombre"));
				u.setapellido(rs.getString("apellido));"
				usuarios.add(u);
			}
		}catch (SQLException e) {
			throw new BDException("error al obtener usuario", e);
		}
		return usuarios;
	}
	public class obtenerusuario1 {
		public List<usuario> obtenerusuario(String nombre, String apellido) throws BDException{
			List<usuario> usuarios = new ArrayList<usuario>();
			String sql = "SELECT id,nombre,apellido FROM usuario WHERE nombre=? AND apellido = ?";
			try(Statement stmt = conn.prepareStatment(sql)){
				stmt.setString(1, nombre);
				stmt.setString(2, apellido);
				
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					usuario u = new usuario();
					u.setid(rs.getInt("id"));
					u.setnombre(rs.getString("nombre"));
					u.setapellido(rs.getString("apellido));"
					usuarios.add(u);
				}
			}catch (SQLException e) {
				throw new BDException("error al obtener usuario", e);
			}
			return usuarios;
		}

}
