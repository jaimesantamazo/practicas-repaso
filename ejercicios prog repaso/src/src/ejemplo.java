import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ejemplo extends JFrame {
	
	private Thread t;
	
	public ejemplo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(640,480);
		setVisible(true);
		
		JPanel panel = new JPanel();
		JButton lanzar = new JButton("lanzar hilo");
		JButton parar = new JButton("parar hilo");
		lanzar.setVisible(true);
		parar.setVisible(true);
		
		panel.add(lanzar);
		panel.add(parar);
		
		add(panel, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			t.interrupt();
		}
		});
			
		lanzar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						while(!Thread.interrupted()) {
							System.out.println("hola, soy un hilo");
						}
						
					}
				});
				t.start();
			}
		});
		parar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.interrupt();
				
			}
		});
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ejemplo();
				
			}
		});
	}

}
