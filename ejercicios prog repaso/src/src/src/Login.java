import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

	private JFrame frame;
	private JTextField textFielduser;
	private JPasswordField passwordFielduser;
	static Logger log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			log = Logger.getLogger("logger");
			Handler h = new FileHandler("Datosprograma.xml");
			log.addHandler(h);
			//log.setUseParentHandlers(false);
			log.setLevel(Level.FINEST);
			h.setLevel(Level.FINEST);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
		log.log(Level.INFO, "Inicio del programa " + new Date());
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}catch(Exception e) {
		log.log(Level.SEVERE, "Error en el inicio de la aplicacion",e);
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error grave", "ERROR",JOptionPane.ERROR_MESSAGE);
	}
		
	}

	/**
	 * Create the application.
	 */
	public Login() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Username:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(59, 102, 115, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(59, 175, 115, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFielduser = new JTextField();
		textFielduser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFielduser.setBounds(204, 99, 220, 35);
		frame.getContentPane().add(textFielduser);
		textFielduser.setColumns(10);
		
		passwordFielduser = new JPasswordField();
		passwordFielduser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordFielduser.setBounds(204, 172, 220, 35);
		frame.getContentPane().add(passwordFielduser);
		
		JButton btnNewButton = new JButton("Salir\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login.log.log(Level.INFO,"Fin del programa");
				
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(59, 237, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
				
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(359, 237, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblIntroduceTusDatos = new JLabel("Bienvenido, loggeate para continuar\r\n");
		lblIntroduceTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceTusDatos.setBackground(Color.WHITE);
		lblIntroduceTusDatos.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblIntroduceTusDatos.setBounds(35, 16, 439, 50);
		frame.getContentPane().add(lblIntroduceTusDatos);
		
		JButton btnNuevaCuenta = new JButton("Nueva cuenta\r\n");
		btnNuevaCuenta.setActionCommand("Open");
		btnNuevaCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

		        if(cmd.equals("Open"))
		        {
		            frame.dispose();
		            new Register();
		            
		        }
			}
		});
		btnNuevaCuenta.setToolTipText("");
		btnNuevaCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNuevaCuenta.setBackground(Color.WHITE);
		btnNuevaCuenta.setBounds(15, 295, 135, 32);
		frame.getContentPane().add(btnNuevaCuenta);
	}

	protected void ingresar() {
		String usuario = textFielduser.getText();
		String contrase�a = String.valueOf(passwordFielduser.getPassword());
		
		gestionusuario gestionusuario = new gestionusuario();
		usuario usuario2 = new usuario();
		usuario2.setUsername(usuario);
		usuario2.setContrase�a(contrase�a);
		
		usuario usu = gestionusuario.obtenerusuario(usuario2);
			
		if(usu!=null) {
			frame.dispose();
			JOptionPane.showMessageDialog(frame, "bienvenido");
			new menu();
			
		}else{
			JOptionPane.showMessageDialog(frame, "Datos no validos", "error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
