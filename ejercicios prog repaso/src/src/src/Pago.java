import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.Caret;

import com.mysql.jdbc.Statement;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Pago {

	private JFrame frame3;
	private JTextField textTarjeta;
	private JTextField textCCV;
	private JTextField textDNI;
	private JTextField textemail;
	private int limiteTarjeta =16;
	private int limiteCCV=3;
	private int limiteFecha=11;
	private int limiteDNI=9;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Pago window = new Pago();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pago() {
		super();
		initialize();
		frame3.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 617, 491);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		JLabel lblCorreo = new JLabel("E-mail:");
		lblCorreo.setBounds(25, 220, 69, 20);
		frame3.getContentPane().add(lblCorreo);

		textemail = new JTextField();
		textemail.setBounds(182, 217, 344, 26);
		frame3.getContentPane().add(textemail);
		textemail.setColumns(10);


		JLabel lblNumeroTarjeta = new JLabel("Numero tarjeta:");
		lblNumeroTarjeta.setBounds(25, 256, 126, 20);
		frame3.getContentPane().add(lblNumeroTarjeta);


		JLabel lblCcv = new JLabel("CCV:");
		lblCcv.setBounds(25, 292, 69, 20);
		frame3.getContentPane().add(lblCcv);


		JLabel lblDniCliente = new JLabel("DNI cliente:");
		lblDniCliente.setBounds(25, 328, 126, 20);
		frame3.getContentPane().add(lblDniCliente);



		JLabel lblIntroduceLosDatos = new JLabel("Introduce los datos de tu tarjeta para validar los datos");
		lblIntroduceLosDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblIntroduceLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLosDatos.setBounds(15, 4, 534, 49);
		frame3.getContentPane().add(lblIntroduceLosDatos);

		textTarjeta= new JTextField();
		textTarjeta.setBounds(182, 253, 237, 26);
		frame3.getContentPane().add(textTarjeta);
		textTarjeta.setColumns(10);


		

		textCCV = new JTextField();
		textCCV.setBounds(182, 289, 132, 26);
		frame3.getContentPane().add(textCCV);
		textCCV.setColumns(10);

		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.GREEN);
		btnPagar.setBounds(182, 390, 115, 29);
		frame3.getContentPane().add(btnPagar);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexion conexion5 = new conexion();
				Connection cn5 = conexion5.conectar();
				String nombre;
				String cantidad;
				cantidad = textField_2.getText();
				nombre = textField_1.getText();
				int numero1 = Integer.parseInt(cantidad);
				String sql = "UPDATE ENTRADAS SET cantidad = ?-1 WHERE NOMBRE = ?";
				if(numero1 >0) {
				try {
					PreparedStatement pst2 = cn5.prepareStatement(sql);
					pst2.setString(1, cantidad);
					pst2.setString(2, nombre);
					int n = pst2.executeUpdate();
					if(n>0) {
						JOptionPane.showMessageDialog(null, "entrada comprada");
					}
					frame3.dispose();
					new menu();	
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}else
					JOptionPane.showMessageDialog(null, "las entradas estan agotadas");

				
			try {
				FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\entrada.txt", true);
				PrintWriter escribir = new PrintWriter(archivo);
				
				String dni;
				String concierto1;
				String email;
				
				dni = textField.getText();
				concierto1 = textField_1.getText();
				email = textemail.getText();
				
				System.out.println(dni);
				System.out.println(concierto1);
				System.out.println(email);
				
				String cadena = "Dni:"+dni+'\n'+"Concierto:"+concierto1+'\n'+"Email:"+email;
				escribir.print(cadena);
				
				archivo.close();
			} catch (IOException e4) {
				e4.printStackTrace();
			}
			
			
		}});


		JButton btnCancel = new JButton("Volver al menu\r\n");
		btnCancel.setActionCommand("Open20");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btnVueltaAlLogin = new JButton("Vuelta al login");
				String cmd20 = e.getActionCommand();

		        if(cmd20.equals("Open20"))
		        {
		            frame3.dispose();
		            new menu();
		        }
			}});
		
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(15, 390, 152, 29);
		frame3.getContentPane().add(btnCancel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(97, 66, 279, 26);
		frame3.getContentPane().add(comboBox);
		

		JLabel lblFestival = new JLabel("Festival:");
		lblFestival.setBounds(25, 69, 69, 20);
		frame3.getContentPane().add(lblFestival);

		JButton btnGestion = new JButton("Gestion");
		btnGestion.setActionCommand("Open40");
		btnGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();

				    if(cmd.equals("Open40"))
				        {
				            frame3.dispose();
				            new loginAdmin();
				            
				        }
					}
			
				});
			
		btnGestion.setBounds(328, 390, 96, 29);
		frame3.getContentPane().add(btnGestion);
		
		textField = new JTextField();
		textField.setBounds(182, 325, 183, 26);
		frame3.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblConciertoSeleccionado = new JLabel("concierto seleccionado:");
		lblConciertoSeleccionado.setBounds(15, 118, 174, 20);
		frame3.getContentPane().add(lblConciertoSeleccionado);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(248, 115, 307, 26);
		frame3.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSeleccion = new JButton("seleccion");
		btnSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringTokenizer st = new StringTokenizer(comboBox.getSelectedItem().toString());
				while(st.hasMoreTokens()) {
					textField_1.setText(st.nextToken().toString());
					textField_2.setText(st.nextToken().toString());
				}
			}
		});
		btnSeleccion.setBounds(434, 65, 115, 29);
		frame3.getContentPane().add(btnSeleccion);
		
		JButton btnNewButton = new JButton("cargar datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion conexion3 = new conexion();
				Connection cn3 = conexion3.conectar();
				Statement stmt;
				try {
				stmt = (Statement) cn3.createStatement();
				String query = "SELECT NOMBRE,CANTIDAD FROM ENTRADAS";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{
				comboBox.addItem(rs.getString(1)+" "+rs.getString(2));
				}
				rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(448, 390, 132, 29);
		frame3.getContentPane().add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(248, 157, 152, 26);
		frame3.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNumeroDeEntradas = new JLabel("numero de entradas restantes:");
		lblNumeroDeEntradas.setBounds(15, 160, 217, 20);
		frame3.getContentPane().add(lblNumeroDeEntradas);

	}
} 