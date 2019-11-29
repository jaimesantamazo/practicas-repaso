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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ejemplojlist extends JFrame{
	
		
		public ejemplojlist() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(640,480);
			setVisible(true);
			
			
			DefaultListModel<String> listmodel = new DefaultListModel<String>();
			JList<String> jlist = new JList<String>(listmodel);
			jlist.setFixedCellWidth(100);
			JScrollPane scrollpane = new JScrollPane(jlist);
			
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
						listmodel.addElement(textfield.getText());
					}
					
				}
			});
			deletetext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int selectedindex = jlist.getSelectedIndex();
					if(selectedindex != -1) {
						listmodel.removeElementAt(selectedindex);
					}
					
				}
			});
		
		}
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new ejemplojlist();
					
				}
			});
		}
}
