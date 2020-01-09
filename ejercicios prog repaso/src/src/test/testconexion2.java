import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class testconexion2 {

	@Test
	public void test() {
		Connection con = null;
		con = conexion2.getConexion();
	}

}
