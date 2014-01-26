package gui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.BHBook;
import control.JTableview;

import com.toedter.calendar.JDateChooser;

public class BookDl extends GUIHelp{
	
	//Startpanel
		public JPanel contentpane1;
		private JButton buttonSearch, buttonBook;
		public JTextField jtfGid, jtfVorname, jtfName; 
		private JLabel labelSearch, labelResult, labelVor, labelGid, labelName, labelGeb; 
		public JDateChooser geb;
		public JScrollPane scrollPaneSuche;
		public JTableview sucheGast;
		public String query;
		
	//Frame	
		public JFrame jf;
		public JPanel contentpane2;
		private JLabel labelGast2, labelDatum2, labelDl2;
		private JTextField labelId2, labelVor2, labelName2, labelZimmer2, labelVon2, labelBis2;
		public JTextField labelId2_2, labelVor2_2, labelName2_2, labelZimmer2_2, labelVon2_2, labelBis2_2;
		public JDateChooser bookDate2;
		private JButton buttonBook2;
		public JScrollPane scrollPaneDl;
		public JTableview tableDl;
		
		
	public JPanel launchStartPanel() {
		
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);
		
		labelSearch = new JLabel("Gastsuche:", JLabel.LEFT);
		labelGid = new JLabel("GID: ", JLabel.LEFT);
		labelVor = new JLabel("Vorname: ", JLabel.LEFT);
		labelName = new JLabel("Nachname: ", JLabel.LEFT);
		labelGeb = new JLabel("Geburtstag: ", JLabel.LEFT);
		labelResult = new JLabel("Suchergebnisse: ", JLabel.LEFT);
		buttonSearch = new JButton("Suchen");
		buttonBook = new JButton("Dienstleistung buchen...");
			
		jtfGid = new JTextField(30);
		jtfVorname = new JTextField(20);
		jtfName = new JTextField(20);
		geb = new JDateChooser();
		
		labelSearch.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane1.add(labelSearch);
		labelGid.setBounds(x_column1, y_line2, x_width, y_height);
		contentpane1.add(labelGid);
		labelVor.setBounds(x_column1, y_line3, x_width, y_height);
		contentpane1.add(labelVor);
		labelName.setBounds(x_column1, y_line4, x_width, y_height);
		contentpane1.add(labelName);
		labelGeb.setBounds(x_column1, y_line5, x_width, y_height);
		contentpane1.add(labelGeb);
		buttonSearch.addActionListener(new BHBook(this));
		buttonSearch.setActionCommand("SEARCHDl");
		buttonSearch.setBounds(x_column1, y_line6, x_width, y_height);
		contentpane1.add(buttonSearch);
		labelResult.setBounds(x_column1, y_line7, x_width, y_height);
		contentpane1.add(labelResult);
		
		
			
		Calendar past = new GregorianCalendar();
		Calendar future = new GregorianCalendar();
		Date now = new Date();
		
		past.setTime(now);
		past.add(Calendar.DAY_OF_MONTH, -30);
		
		future.setTime(now);
		future.add(Calendar.DAY_OF_MONTH, 30);

		SimpleDateFormat Sql = new SimpleDateFormat("yyyy-MM-dd");		
		Sql.format(future.getTime());
		Sql.format(past.getTime());
		System.out.println(Sql.format(future.getTime()) +" "+Sql.format(past.getTime()));
		
		//query = "SELECT hotel.gast.GID, hotel.gast.Vorname, hotel.gast.Name, hotel.gast.Geburtstag, hotel.buchung.BID, hotel.`zimmer-buchung`.ZID, hotel.`zimmer-buchung`.Von, hotel.`zimmer-buchung`.Bis from hotel.gast, hotel.buchung, hotel.`zimmer-buchung` where hotel.gast.GID = hotel.buchung.GID AND hotel.buchung.BID = hotel.`zimmer-buchung`.BID AND (hotel.`zimmer-buchung`.Von between '"+Sql.format(past.getTime())+"' and '"+Sql.format(future.getTime())+"' OR hotel.`zimmer-buchung`.Bis between '"+Sql.format(past.getTime())+"' and '"+Sql.format(future.getTime())+"')";
		query = "SELECT hotel.gast.GID, hotel.gast.Vorname, hotel.gast.Name, hotel.gast.Geburtstag, hotel.buchung.BID, hotel.`zimmer-buchung`.ZID, hotel.`zimmer-buchung`.Von, hotel.`zimmer-buchung`.Bis from hotel.gast, hotel.buchung, hotel.`zimmer-buchung` where hotel.gast.GID = hotel.buchung.GID AND hotel.buchung.BID = hotel.`zimmer-buchung`.BID";
		sucheGast = new JTableview(query);
		JTable suche = sucheGast.getSQLTable();
		scrollPaneSuche = new JScrollPane(suche);
		scrollPaneSuche.setBounds(x_column1, y_line8, 1000, 200);
		contentpane1.add(scrollPaneSuche);
		
		buttonBook.setBounds(x_column1, y_line14, 200, y_height);
		buttonBook.addActionListener(new BHBook(this));
		buttonBook.setActionCommand("NewBookingDl");
		contentpane1.add(buttonBook);
		
		jtfGid.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane1.add(jtfGid);
		jtfVorname.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane1.add(jtfVorname);
		jtfName.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane1.add(jtfName);
		setGebRoom(geb);
		geb.setBounds(x_column3, y_line5, x_width, y_height);
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
		labelId2.setBounds(x_column1, y_line2, 100, y_height);
		contentpane2.add(labelId2);
		labelId2_2.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane2.add(labelId2_2);
		labelVor2.setBounds(x_column1, y_line3, 100, y_height);
		contentpane2.add(labelVor2);
		labelVor2_2.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane2.add(labelVor2_2);
		labelName2.setBounds(x_column1, y_line4, 100, y_height);
		contentpane2.add(labelName2);
		labelName2_2.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane2.add(labelName2_2);
		labelZimmer2.setBounds(x_column4, y_line2, 100, y_height);
		contentpane2.add(labelZimmer2);
		labelZimmer2_2.setBounds(x_column5, y_line2, x_width, y_height);
		contentpane2.add(labelZimmer2_2);
		labelVon2.setBounds(x_column4, y_line3, 100, y_height);
		contentpane2.add(labelVon2);
		labelVon2_2.setBounds(x_column5, y_line3, x_width, y_height);
		contentpane2.add(labelVon2_2);
		labelBis2.setBounds(x_column4, y_line4, 100, y_height);
		contentpane2.add(labelBis2);
		labelBis2_2.setBounds(x_column5, y_line4, x_width, y_height);
		contentpane2.add(labelBis2_2);
		labelDatum2.setBounds(x_column1, y_line5, 100, y_height);
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
		
		tableDl = new JTableview("select * from dienstleistung");
		JTable table = tableDl.getSQLTable();
		scrollPaneDl= new JScrollPane(table);
		scrollPaneDl.setBounds(x_column4, y_line6, 200, 100);
		contentpane2.add(scrollPaneDl);
		
		jf.setVisible(true);
		jf.setResizable(true);
		jf.setSize(600,500);
		jf.setLocation(300,50);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String getVorSuche() {
		return jtfVorname.getText();
	}
	
	public String getNameSuche() {
		return jtfName.getText();
	}
	
	public String getGidSuche() {
		return jtfGid.getText();
	}
	
	public Date getGebSuche() {
		return geb.getDate();
	}
	
	public String getQuery() {
		return query;
	}
	
}
