package GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class BookDl extends Coordinates{
	
	//Startpanel
		private JPanel contentpane1;
		private JButton jb1, jb2, jb3;
		public JTextField jtfVorname, jtfName; 
		private JLabel searchGast, labelVor, labelName, labelGeb; 
		public JDateChooser geb;
		
	public JPanel launchStartPanel() {
		
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);
		
		searchGast = new JLabel("Kundensuche:", JLabel.LEFT);
		labelVor = new JLabel("Vorname: ", JLabel.LEFT);
		labelName = new JLabel("Nachname: ", JLabel.LEFT);
		labelGeb = new JLabel("Geburtstag: ", JLabel.LEFT);
		
		
		jtfVorname = new JTextField(20);
		jtfName = new JTextField(20);
		geb = new JDateChooser();
		
		
		
		
		
		searchGast.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane1.add(searchGast);
		labelVor.setBounds(x_column1, y_line2, x_width, y_height);
		contentpane1.add(labelVor);
		labelName.setBounds(x_column1, y_line3, x_width, y_height);
		contentpane1.add(labelName);
		labelGeb.setBounds(x_column1, y_line4, x_width, y_height);
		contentpane1.add(labelGeb);
		
		jtfVorname.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane1.add(jtfVorname);
		jtfName.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane1.add(jtfName);
		geb.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane1.add(geb);
		
		return contentpane1;
	}
		
	
}
