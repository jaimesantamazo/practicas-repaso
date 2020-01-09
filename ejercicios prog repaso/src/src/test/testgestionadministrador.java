import static org.junit.Assert.*;

import org.junit.Test;

public class testgestionadministrador {
	
	@Test
	public void testobteneradministrador() {
		administrador admin1 = new administrador();
		gestionadministrador gestionadministracion = new gestionadministrador();
		administrador admin = gestionadministracion.obteneradministrador(admin1);
	}

}
