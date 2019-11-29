package serializable;

import java.io.Serializable;

public class alumno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6357258388789291905L;
	
	private String nombre;
	private String apellido;
	
	public alumno() {
		
	}
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
