
public class administrador extends usuario{
	private String usuario;
	private String contrase�a;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String constrase�a) {
		this.contrase�a = constrase�a;
	}
	public administrador(String usuario, String constrase�a) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}
	public administrador() {}
	
	

}
