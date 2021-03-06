package gui;

import java.awt.Color;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import control.BHCancel;
import control.JTableview;

public class CancelZimmer extends GUIHelp{
	
		//ButtonHandler wird erzeugt
		BHCancel ButtonHandler = new BHCancel(this);
		//GUI-Objekte werden erstellt
		public JPanel contentpane1;
		private JButton buttonCancelZimmer, buttonSearch;
		private JLabel labelCancelZimmer, labelGid, labelVor, labelName, labelGeb; 
		public JTextField jtfGid, jtfVor, jtfName;
		public JDateChooser geb; 
		public JScrollPane scrollPaneSuche;
		public JTableview sucheBu;
		private String query;
		
	public JPanel launchStartPanel(){
		//contentpane wird erzeugt, Layout auf null gesetzt
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);

		//GUI-Objekte werden erzeugt
		labelCancelZimmer = new JLabel("Zimmerbuchung stornieren:");	
		buttonCancelZimmer = new JButton("Stornieren");
		buttonSearch = new JButton("Suchen");
		labelGid = new JLabel("GID: ", JLabel.LEFT);
		labelVor = new JLabel("Vorname: ", JLabel.LEFT);
		labelName = new JLabel("Name: ", JLabel.LEFT);
		labelGeb = new JLabel("Geburtsdatum: ", JLabel.LEFT);
		jtfGid = new JTextField();
		jtfVor = new JTextField();
		jtfName = new JTextField();
		geb = new JDateChooser();
		
		//ActionListener und ActionCommand f�r Buttons werden gesetzt
		buttonSearch.addActionListener(new BHCancel(this));
		buttonSearch.setActionCommand("SearchBu");
		buttonCancelZimmer.addActionListener(ButtonHandler);
		buttonCancelZimmer.setActionCommand("CancelZimmer?");
		
		//Query f�r SQL-Tabelle in Startpanel wird gesetzt
		query = "select hotel.gast.GID, hotel.gast.Vorname, hotel.gast.Name, hotel.gast.Geburtstag, hotel.buchung.BID, hotel.`zimmer-buchung`.ZID, hotel.`zimmer-buchung`.Von, hotel.`zimmer-buchung`.Bis from hotel.gast, hotel.buchung, hotel.`zimmer-buchung`	where hotel.gast.GID = hotel.buchung.GID and hotel.buchung.BID = hotel.`zimmer-buchung`.BID and hotel.`zimmer-buchung`.Von > '"+getSQLDate(new Date())+"'";
		
		//Koordinaten und Gr��e der GUI-Objekte wird gesetzt und zu contentpane hinzugef�gt
		labelCancelZimmer.setBounds(x_column1, y_line1, 200, y_height);
		contentpane1.add(labelCancelZimmer);
		labelGid.setBounds(x_column1, y_line2, x_width, y_height);
		contentpane1.add(labelGid);
		labelVor.setBounds(x_column1, y_line3, x_width, y_height);
		contentpane1.add(labelVor);
		labelName.setBounds(x_column1, y_line4, x_width, y_height);
		contentpane1.add(labelName);
		labelGeb.setBounds(x_column1, y_line5, x_width, y_height);
		contentpane1.add(labelGeb);
		jtfGid.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane1.add(jtfGid);
		jtfVor.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane1.add(jtfVor);
		jtfName.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane1.add(jtfName);
		//Datumsraum f�r Geburtsdatum wird gesetzt
		setGebRoom(geb);
		geb.setBounds(x_column3, y_line5, x_width, y_height);
		contentpane1.add(geb);
		buttonSearch.setBounds(x_column1, y_line6, x_width, y_height);
		contentpane1.add(buttonSearch);
		buttonCancelZimmer.setBounds(x_column1, y_line14, x_width, y_height);
		contentpane1.add(buttonCancelZimmer);
		
		//Tabelle f�r stornierbare Zimmer wird erzeugt und zu contentpane hinzugef�gt
		sucheBu = new JTableview(query);
		JTable suche = sucheBu.getSQLTable();
		scrollPaneSuche = new JScrollPane(suche);
		scrollPaneSuche.setBounds(x_column1, y_line7, 1000, 200);
		contentpane1.add(scrollPaneSuche);
		
		//Hintergrundfarbe
		contentpane1.setOpaque(true);
		contentpane1.setBackground(new Color(209,218,248));
	
		//contentpane wird zur�ckgegeben
		return contentpane1;
	}
	
	//getter-Methoden
	public String getGidSuche(){
		return jtfGid.getText();
	}
	
	public String getVorSuche(){
		return jtfVor.getText();
	}
	
	public String getNameSuche(){
		return jtfName.getText();
	}
	
	public Date getGebSuche(){
		return geb.getDate();
	}
	
	public String getQuery(){
		return query;
	}
}
