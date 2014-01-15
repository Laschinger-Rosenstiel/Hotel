package GUI;

import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Control.BHBook;
import com.toedter.calendar.JDateChooser;

public class BookDl extends GUIHelp{
	
	//Startpanel
		private JPanel contentpane1;
		private JButton buttonSearch, buttonBook;
		public JTextField jtfVorname, jtfName; 
		private JLabel labelSearch, labelResult, labelVor, labelName, labelGeb; 
		public JDateChooser geb;
		
	//Frame	
		public JFrame jf;
		public JPanel contentpane2;
		private JLabel labelGast2, labelDatum2, labelDl2;
		private JTextField labelId2, labelVor2, labelName2, labelZimmer2, labelVon2, labelBis2;
		public JTextField labelId2_2, labelVor2_2, labelName2_2, labelZimmer2_2, labelVon2_2, labelBis2_2;
		public JDateChooser bookDate2;
		private JButton buttonBook2;
		
	public JPanel launchStartPanel() {
		
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);
		
		labelSearch = new JLabel("Gastsuche:", JLabel.LEFT);
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
		buttonBook.addActionListener(new BHBook(this));
		buttonBook.setActionCommand("NewBookingDl");
		contentpane1.add(buttonBook);
		
		jtfVorname.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane1.add(jtfVorname);
		jtfName.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane1.add(jtfName);
		setGebRoom(geb);
		geb.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane1.add(geb);
		
		return contentpane1;
	}
		
	public void launchJFrame() {
		jf = new JFrame("Dienstleistung buchen");
		contentpane2 = new JPanel();
		contentpane2.setLayout(null);
		labelGast2 = new JLabel("Gastdaten: ");
		labelId2 = new JTextField("Gastnummer: ");
		setTfForm(labelId2);
		labelId2_2 = new JTextField();
		setTfForm(labelId2_2);
		labelVor2 = new JTextField("Vorname: ");
		setTfForm(labelVor2);
		labelVor2_2 = new JTextField();
		setTfForm(labelVor2_2);
		labelName2 = new JTextField("Name: ");
		setTfForm(labelName2);
		labelName2_2 = new JTextField();
		setTfForm(labelName2_2);
		labelZimmer2 = new JTextField("Zimmer: ");
		setTfForm(labelZimmer2);
		labelZimmer2_2 = new JTextField();
		setTfForm(labelZimmer2_2);
		labelVon2 = new JTextField("Von: ");
		setTfForm(labelVon2);
		labelVon2_2 = new JTextField();
		setTfForm(labelVon2_2);
		labelBis2 = new JTextField("Bis: ");
		setTfForm(labelBis2);
		labelBis2_2 = new JTextField();
		setTfForm(labelBis2_2);
		labelDatum2 = new JLabel("Buchungsdatum:");
		bookDate2 = new JDateChooser();
		labelDl2 = new JLabel("Dienstleistungen: ");
		buttonBook2 = new JButton("Buchen");
		
		jf.setContentPane(contentpane2);
		
		labelGast2.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane2.add(labelGast2);
		labelId2.setBounds(x_column1, y_line2, x_width, y_height);
		contentpane2.add(labelId2);
		labelId2_2.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane2.add(labelId2);
		labelVor2.setBounds(x_column1, y_line3, x_width, y_height);
		contentpane2.add(labelVor2);
		labelVor2_2.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane2.add(labelVor2_2);
		labelName2.setBounds(x_column1, y_line4, x_width, y_height);
		contentpane2.add(labelName2);
		labelName2_2.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane2.add(labelName2_2);
		labelZimmer2.setBounds(x_column4, y_line2, x_width, y_height);
		contentpane2.add(labelZimmer2);
		labelZimmer2_2.setBounds(x_column5, y_line2, x_width, y_height);
		contentpane2.add(labelZimmer2_2);
		labelVon2.setBounds(x_column4, y_line3, x_width, y_height);
		contentpane2.add(labelVon2);
		labelVon2_2.setBounds(x_column5, y_line3, x_width, y_height);
		contentpane2.add(labelVon2_2);
		labelBis2.setBounds(x_column4, y_line4, x_width, y_height);
		contentpane2.add(labelBis2);
		labelBis2_2.setBounds(x_column5, y_line4, x_width, y_height);
		contentpane2.add(labelBis2_2);
		labelDatum2.setBounds(x_column1, y_line5, x_width, y_height);
		contentpane2.add(labelDatum2);
		bookDate2.setBounds(x_column1, y_line6, 100, y_height);
		bookDate2.setSelectableDateRange(new Date(), null);
		contentpane2.add(bookDate2);
		labelDl2.setBounds(x_column4, y_line5, x_width, y_height);
		contentpane2.add(labelDl2);
		buttonBook2.setBounds(x_column1, y_line10, x_width, y_height);
		buttonBook2.addActionListener(new BHBook(this));
		buttonBook2.setActionCommand("BOOK?Dl");
		contentpane2.add(buttonBook2);
		
		jf.setVisible(true);
		jf.setResizable(true);
		jf.setSize(600,500);
		jf.setLocation(300,50);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/*public static void main(String[] args)
	{
		BookDl bookDl = new BookDl();
		bookDl.launchJFrame();
		
	}
	*/
	
}
