
public class administrador extends usuario{
	private String usuario;
	private String contraseña;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String constraseña) {
		this.contraseña = constraseña;
	}
	public administrador(String usuario, String constraseña) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	public administrador() {}
	
	

}
