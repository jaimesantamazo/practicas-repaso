import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class loginAdmin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginAdmin window = new loginAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginAdmin() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(67, 142, 92, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Constrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(67, 210, 132, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(214, 138, 226, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblLoggeateConTu = new JLabel("Loggeate con tu cuenta administrador para la gestion");
		lblLoggeateConTu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoggeateConTu.setBounds(15, 35, 487, 51);
		frame.getContentPane().add(lblLoggeateConTu);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setActionCommand("Open90");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String cmd = e.getActionCommand();
						 if(cmd.equals("Open90"))
					        {
					            frame.dispose();
					            new Pago();
					            
					        }
					}
				});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(67, 280, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresaradmin();
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(325, 280, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(214, 206, 226, 29);
		frame.getContentPane().add(passwordField);
	}
	protected void ingresaradmin() {
		String usuario = textField.getText();
		String contrase�a = String.valueOf(passwordField.getPassword());
		
		gestionadministrador gestionadministrador = new gestionadministrador();
		administrador administrador2 = new administrador();
		administrador2.setUsuario(usuario);
		administrador2.setContrase�a(contrase�a);
		
		administrador admin = gestionadministrador.obteneradministrador(administrador2);
			
		if(admin!=null) {
			frame.dispose();
			JOptionPane.showMessageDialog(frame, "bienvenido");
			new gestion();
			
		}else{
			JOptionPane.showMessageDialog(frame, "Datos no validos", "error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
