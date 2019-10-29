import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JTextPane;

public class Mainmenu {

	private JFrame frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainmenu window = new Mainmenu();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainmenu() {
		super();
		initialize();
		frame2.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBackground(Color.WHITE);
		frame2.setBounds(100, 100, 624, 600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel panel = new JPanel();
		frame2.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("DREAMBEACH");
		lblNewLabel_10.setForeground(Color.BLACK);
		lblNewLabel_10.setBackground(Color.WHITE);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		panel.add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("informacion");
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		frame2.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("MEDUSA");
		lblNewLabel_11.setForeground(Color.BLACK);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		panel_1.add(lblNewLabel_11);
		
		JButton btnNewButton_1 = new JButton("informacion");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		frame2.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("RIVERLAND\r\n");
		lblNewLabel_12.setForeground(Color.BLACK);
		lblNewLabel_12.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_12);
		
		JButton btnNewButton_2 = new JButton("informacion");
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		frame2.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_13 = new JLabel("BILBAO BBK");
		lblNewLabel_13.setForeground(Color.BLACK);
		lblNewLabel_13.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_13);
		
		JButton btnNewButton_3 = new JButton("informacion");
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		frame2.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_14 = new JLabel("VI\u00D1A ROCK\r\n");
		lblNewLabel_14.setForeground(Color.BLACK);
		lblNewLabel_14.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_14);
		
		JButton btnNewButton_4 = new JButton("informacion");
		panel_4.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame2.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("imagenes/dreambeach.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		frame2.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("imagenes/medusa.jpg"));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		frame2.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("imagenes/riverland.jpeg"));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		frame2.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("imagenes/bbk.jpg"));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		frame2.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("imagenes/vi�arock.jpg"));
		
		JTextPane txtpnElMacroeventoAlmeriense = new JTextPane();
		txtpnElMacroeventoAlmeriense.setEditable(false);
		txtpnElMacroeventoAlmeriense.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnElMacroeventoAlmeriense.setText("El macroevento almeriense Dreambeach, uno de los festivales de electr\u00F3nica m\u00E1s importantes del panorama nacional");
		frame2.getContentPane().add(txtpnElMacroeventoAlmeriense);
		
		JTextPane txtpnMedusaFestivalEs = new JTextPane();
		txtpnMedusaFestivalEs.setEditable(false);
		txtpnMedusaFestivalEs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnMedusaFestivalEs.setText("Medusa Festival es un festival de m\u00FAsica dance que se celebra en Cullera. En esta playa valenciana unen fuerzas DJs de los mundos mainstream y underground");
		frame2.getContentPane().add(txtpnMedusaFestivalEs);
		
		JTextPane txtpnElFestivalAsturiano = new JTextPane();
		txtpnElFestivalAsturiano.setEditable(false);
		txtpnElFestivalAsturiano.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnElFestivalAsturiano.setText("el festival asturiano que intenta hacerse hueco en el panorama nacional. M\u00E1s de 20.000 personas podran disfrutar de este evento");
		frame2.getContentPane().add(txtpnElFestivalAsturiano);
		
		JTextPane txtpnBilbaoBbkLive = new JTextPane();
		txtpnBilbaoBbkLive.setEditable(false);
		txtpnBilbaoBbkLive.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnBilbaoBbkLive.setText("Uno de los festivales m\u00E1s populares y multitudinarios del panorama nacional que prepara as\u00ED su decimocuarta edici\u00F3n");
		frame2.getContentPane().add(txtpnBilbaoBbkLive);
		
		JTextPane txtpnDelDe = new JTextPane();
		txtpnDelDe.setEditable(false);
		txtpnDelDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnDelDe.setText(" Del 30 de abril al 2 de mayo de 2020 celebramos el 25 aniversario del festival arte-nativo m\u00E1s importante del pa\u00EDs.");
		frame2.getContentPane().add(txtpnDelDe);
	}

}
