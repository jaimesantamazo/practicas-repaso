import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ejemplotabla extends JFrame{
	
		
		public ejemplotabla() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(640,480);
			setVisible(true);
			
			DefaultTableModel tablemodel = new DefaultTableModel();
			String[] columnnames = {"columna a", "columna b"};
			tablemodel.setColumnIdentifiers(columnnames);
			JTable jtable = new JTable(tablemodel);
		
			JScrollPane scrollpane = new JScrollPane();
			add(scrollpane, BorderLayout.WEST);
			
			JPanel panel = new JPanel();
			add(panel, BorderLayout.CENTER);
			
			JTextField textfield = new JTextField(20);
			JButton addtext = new JButton("añadir texto");
			
			JButton deletetext = new JButton("eliminar seleccion");
			panel.add(addtext);
			panel.add(textfield);
			panel.add(deletetext);
			
			addtext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!textfield.getText().isEmpty()) {
						String[] fila = {textfield.getText(), "nose"};
						tablemodel.addRow(fila);
					}
					
				}
			});
			
		}		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new ejemplotabla();
					
				}
			});
		}
}