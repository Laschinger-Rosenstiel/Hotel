package gui;

import java.awt.Color;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.BHOther;
import control.JTableview;

import com.toedter.calendar.JDateChooser;

public class CalcPreis extends GUIHelp{
	
		BHOther ButtonHandler = new BHOther(this);
	//Startpanel
	
		public JPanel contentpane1;
		private JButton buttonSearchGast;
		private JLabel labelSearchGast, labelGid, labelVor, labelName, labelGeb, labelBookings;
		public JTextField jtfGid, jtfVor, jtfName;
		public JDateChooser geb;
		public JTableview searchBu;
		public JScrollPane scrollPaneSuche;
		private String query;
	
	public JPanel launchStartPanel() {
		
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);

		labelSearchGast = new JLabel("Gastsuche:");
		labelGid = new JLabel("GID: ");
		labelVor = new JLabel("Vorname");
		labelName = new JLabel("Name");
		labelGeb = new JLabel("Geburtstag");
		labelBookings = new JLabel("Buchungen:");
		query = "select hotel.gast.GID, hotel.gast.Vorname, hotel.gast.Name, hotel.gast.Geburtstag, "+ 
				"hotel.buchung.BID, hotel.`zimmer-buchung`.ZID, hotel.buchung.Gesamtpreis "+ 
				"from hotel.gast, hotel.buchung, hotel.`zimmer-buchung` "+
				"where hotel.gast.GID = hotel.buchung.GID " +
				"and hotel.buchung.BID = hotel.`zimmer-buchung`.BID";
		searchBu = new JTableview(query);
		JTable suche = searchBu.getSQLTable();
		scrollPaneSuche = new JScrollPane(suche);
		
		jtfGid = new JTextField();
		jtfVor = new JTextField();
		jtfName = new JTextField();
		
		buttonSearchGast = new JButton("Suchen...");
		
		geb = new JDateChooser();
		
		labelSearchGast.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane1.add(labelSearchGast);
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
		
		buttonSearchGast.setBounds(x_column1, y_line6, x_width, y_height);
		buttonSearchGast.addActionListener(ButtonHandler);
		buttonSearchGast.setActionCommand("Search");
		contentpane1.add(buttonSearchGast);
		labelBookings.setBounds(x_column1, y_line7, x_width, y_height);
		contentpane1.add(labelBookings);
		scrollPaneSuche.setBounds(x_column1, y_line8, 1000, 200);
		contentpane1.add(scrollPaneSuche);
		
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


