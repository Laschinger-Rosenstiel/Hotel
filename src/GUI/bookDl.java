package GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class bookDl extends Coordinates{
	
	//Startpanel
		private JPanel contentpane1;
		private JButton jb1, jb2, jb3;
		public JTextField jtfVorname, jtfName; 
		private JLabel searchGast; 
		public JDateChooser geb;
		
	public JPanel launchStartPanel() {
		
		contentpane1 = new JPanel();
		
		searchGast = new JLabel("Kundensuche:");
		
		searchGast.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane1.add(searchGast);
	
		
		
		
		return contentpane1;
	}
		
	
}
