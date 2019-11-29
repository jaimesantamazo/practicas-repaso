package crearcarpetas;

 import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
 
public class ejemploproperties {
	
	public static void main(String[]args) {
		Properties p = new Properties();
		p.setProperty("carpeta", "c:\\users\\all\\datos");
		p.setProperty("usuario", "maria");
		p.setProperty("ventana", "640,480");
		
	try {
		FileOutputStream fos = new FileOutputStream(new File("config.ini"));
		try {	
			p.store(fos, "esto es un ejemplo de configuracion");
	}catch(IOException e) {
		System.out.println("no se ha podido abrir el fichero. " + e.getMessage());
	}finally {
		try {
			fos.close();
		}catch(IOException e) {
			//
		}
	}
	}catch (FileNotFoundException e) {
		System.out.println("no se ha podidio escribir en el fichero. " + e.getMessage());
	}
	System.out.println("programa terminado");
	}
}
