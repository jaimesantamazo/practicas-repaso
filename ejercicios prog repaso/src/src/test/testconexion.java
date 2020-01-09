import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class testconexion {

	@Test
	public void test() {
		conexion conexion = new conexion();
		Connection cn = conexion.conectar();
	}

}
