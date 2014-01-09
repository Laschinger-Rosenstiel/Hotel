package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class BookDl extends GUIHelp{
	
	//Startpanel
		
		private JPanel contentpane1;
		private JButton buttonSearch, buttonBook, jb3;
		public JTextField jtfVorname, jtfName; 
		private JLabel labelSearch, labelResult, labelVor, labelName, labelGeb; 
		public JDateChooser geb;
		
	//Frame	
		private JFrame jf;
		public JPanel contentpane2;
		private JLabel labelBook;
		private JTextField labelVor2, labelName2, labelZimmer2, labelVon2, labelBis2;
		
		
	public JPanel launchStartPanel() {
		
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);
		
		labelSearch = new JLabel("Kundensuche:", JLabel.LEFT);
		labelVor = new JLabel("Vorname: ", JLabel.LEFT);
		labelName = new JLabel("Nachname: ", JLabel.LEFT);
		labelGeb = new JLabel("Geburtstag: ", JLabel.LEFT);
		labelResult = new JLabel("Suchergebnisse: ", JLabel.LEFT);
		buttonSearch = new JButton("Suchen");
		buttonBook = new JButton("Dienstleistung buchen...");
			
		jtfVorname = new JTextField(20);
		jtfName = new JTextField(20);
		geb = new JDateChooser();
		
		labelSearch.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane1.add(labelSearch);
		labelVor.setBounds(x_column1, y_line2, x_width, y_height);
		contentpane1.add(labelVor);
		labelName.setBounds(x_column1, y_line3, x_width, y_height);
		contentpane1.add(labelName);
		labelGeb.setBounds(x_column1, y_line4, x_width, y_height);
		contentpane1.add(labelGeb);
		buttonSearch.setBounds(x_column1, y_line5, x_width, y_height);
		contentpane1.add(buttonSearch);
		labelResult.setBounds(x_column1, y_line6, x_width, y_height);
		contentpane1.add(labelResult);
		buttonBook.setBounds(x_column1, y_line13, 200, y_height);
		contentpane1.add(buttonBook);
		
		jtfVorname.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane1.add(jtfVorname);
		jtfName.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane1.add(jtfName);
		geb.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane1.add(geb);
		
		return contentpane1;
	}
		
	public void launchJFrame() {
		jf = new JFrame("Dienstleistung buchen");
		
		jf.setContentPane(contentpane2);
		
		
		
		jf.setVisible(true);
		jf.setResizable(true);
		jf.setSize(600,500);
		jf.setLocation(300,50);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
}
