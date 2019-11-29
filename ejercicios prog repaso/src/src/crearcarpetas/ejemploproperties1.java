package crearcarpetas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ejemploproperties1 {
	
	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File("config.ini"));
			try {
				p.load(fis);
				System.out.println(p.getProperty("carpeta"));
				System.out.println(p.getProperty("usuario"));
			}catch (IOException e) {
				System.out.println("no se ha podidio leer el fichero. " + e.getMessage());
			}finally {
				try {
					fis.close();
				}catch (IOException e) {
					//
				}
				
			}
		} catch (FileNotFoundException e){
			System.out.println("no se ha podidio encontrar el fichero. " + e.getMessage());
		}
	}

}
