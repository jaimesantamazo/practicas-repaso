
public class persona {
	private String nombre;
	private String apellido;
	private String nombrecompleto;
	
	public persona() {}
	
	public persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombrecompleto() {
		return apellido + ", " + nombre;
	}


}
