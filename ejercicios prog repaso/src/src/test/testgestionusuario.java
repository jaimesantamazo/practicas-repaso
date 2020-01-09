import static org.junit.Assert.*;

import org.junit.Test;

public class testgestionusuario {

	@Test
	public void testusuario() {
		usuario usuario = new usuario();
		gestionusuario gestionusuario = new gestionusuario();
		usuario usuario1 = gestionusuario.obtenerusuario(usuario);
	}

}
