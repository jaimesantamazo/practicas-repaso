import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


import javax.swing.JOptionPane;


public class properties extends Thread{
	
	static Properties config = new Properties();
    static InputStream configInput = null;
    static OutputStream configoutput = null;
    
    public void run(){
        try{
            configInput = new FileInputStream("entrada.txt");
            config.load(configInput);
            System.out.println(config.getProperty("Dni"));
            System.out.println(config.getProperty("Concierto"));
            System.out.println(config.getProperty("Email"));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No has comprado entradas, " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void setPropertyValue(String property, String value){
        try{
            configoutput = new FileOutputStream("data/config.properties");
            config.setProperty(property, value);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No has comprado entradas,  " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
