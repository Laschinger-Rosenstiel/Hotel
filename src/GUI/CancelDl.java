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

public class CancelDl extends GUIHelp{
		
		BHCancel ButtonHandler = new BHCancel(this);
	//Startpanel
		public JPanel contentpane1;
		private JButton buttonCancelDl, buttonSearch;
		private JLabel labelCancelDl, labelGid, labelVor, labelName, labelGeb; 
		public JTextField jtfGid, jtfVor, jtfName;
		public JDateChooser geb; 
		public JScrollPane scrollPaneSuche;
		public JTableview sucheBu;
		private String query;
		
		
	public JPanel launchStartPanel(){
		//Objekte erzeugen
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);

		labelCancelDl = new JLabel("Zimmerbuchung stornieren:");	
		buttonCancelDl = new JButton("Stornieren");
		buttonSearch = new JButton("Suchen");
		labelGid = new JLabel("GID: ", JLabel.LEFT);
		labelVor = new JLabel("Vorname: ", JLabel.LEFT);
		labelName = new JLabel("Name: ", JLabel.LEFT);
		labelGeb = new JLabel("Geburtsdatum: ", JLabel.LEFT);
		
		jtfGid = new JTextField();
		jtfVor = new JTextField();
		jtfName = new JTextField();
		
		geb = new JDateChooser();
		
		labelCancelDl.setBounds(x_column1, y_line1, 200, y_height);
		contentpane1.add(labelCancelDl);
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
		
		setGebRoom(geb);
		geb.setBounds(x_column3, y_line5, x_width, y_height);
		contentpane1.add(geb);
		
		buttonSearch.setBounds(x_column1, y_line6, x_width, y_height);
		buttonSearch.addActionListener(ButtonHandler);
		buttonSearch.setActionCommand("SearchDl");
		contentpane1.add(buttonSearch);
		
		
		//query = "select hotel.gast.GID, hotel.gast.Vorname, hotel.gast.Name, hotel.gast.Geburtstag, hotel.buchung.BID, hotel.`zimmer-buchung`.ZID, hotel.`zimmer-buchung`.Von, hotel.`zimmer-buchung`.Bis from hotel.gast, hotel.buchung, hotel.`zimmer-buchung`	where hotel.gast.GID = hotel.buchung.GID and hotel.buchung.BID = hotel.`zimmer-buchung`.BID and hotel.`zimmer-buchung`.Von > '"+getSQLDate(new Date())+"'";
		query = "select hotel.gast.GID, hotel.gast.Vorname, hotel.gast.Name, hotel.gast.Geburtstag, hotel.`dl-buchung`.BID, hotel.`dl-buchung`.DLBID, hotel.`dl-buchung`.Datum, hotel.dienstleistung.Bezeichnung, hotel.dienstleistung.Preis from hotel.gast, hotel.buchung, hotel.`dl-buchung`, hotel.dienstleistung where hotel.gast.GID = hotel.buchung.GID and hotel.buchung.BID = hotel.`dl-buchung`.BID and hotel.`dl-buchung`.DID = hotel.dienstleistung.DID and hotel.`dl-buchung`.Datum > '"+getSQLDate(new Date())+"'";
		
		sucheBu = new JTableview(query);
		JTable suche = sucheBu.getSQLTable();
		
		scrollPaneSuche = new JScrollPane(suche);
		scrollPaneSuche.setBounds(x_column1, y_line7, 1000, 200);
		contentpane1.add(scrollPaneSuche);
		
		
		
		buttonCancelDl.addActionListener(ButtonHandler);
		buttonCancelDl.setActionCommand("CancelDl?");
		buttonCancelDl.setBounds(x_column1, y_line14, x_width, y_height);
		contentpane1.add(buttonCancelDl);
		
		//Color
		contentpane1.setOpaque(true);
		contentpane1.setBackground(new Color(209,218,248));
	
		return contentpane1;
	}
	
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
