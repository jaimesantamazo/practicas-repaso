package serializable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ejemplo {

	public static void main(String[] args) {
		alumno a = new alumno();
		a.setNombre("jaime");
		a.setApellido("santamaria");
		
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("datos.bin")))){
			os.writeObject(a);
		}catch (FileNotFoundException e) {
			System.out.println("no se ha enconrtado el fichero");
		}catch (IOException e) {
			System.out.println("no se ha podido serializar el objeto");
		}

	}

}
