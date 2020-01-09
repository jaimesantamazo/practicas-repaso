import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class gestionadministrador {
	public administrador obteneradministrador(administrador admin) {
		administrador administrador = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = conexion2.getConexion();
			String sql = "select * from administrador where usuario = ? and contraseña = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, admin.getUsuario());
			pst.setString(2, admin.getContraseña());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				administrador = new administrador(rs.getString(1), rs.getString(2));
			}
			
		}catch (Exception e) {
			System.out.println("error en obtener administrador");
		}
		return administrador;
	}

}
