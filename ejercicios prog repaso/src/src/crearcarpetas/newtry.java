package crearcarpetas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class newtry {
	
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream(new File("confif.ini"))){
			Properties p = new Properties();
			p.load(fis);
			System.out.println(p.getProperty("usuario"));
		}catch(FileNotFoundException e) {
			System.out.println("no se ha podido abrir el fichero");
		}catch(IOException e) {
			System.out.println("no se ha podidio leer del fichero");
		}
				
	}

}
