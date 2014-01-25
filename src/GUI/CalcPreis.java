package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.BHOther;

import com.toedter.calendar.JDateChooser;

public class CalcPreis extends GUIHelp{
	
		BHOther ButtonHandler = new BHOther(this);
	//Startpanel
	
		private JPanel contentpane1;
		private JButton buttonSearchGast;
		private JLabel labelSearchGast, labelVor, labelName, labelGeb, labelBookings;
		public JTextField jtfVor, jtfName;
		public JDateChooser geb;
		
		
	
	public JPanel launchStartPanel() {
		
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);

		labelSearchGast = new JLabel("Gastsuche:");
		labelVor = new JLabel("Vorname");
		labelName = new JLabel("Name");
		labelGeb = new JLabel("Geburtstag");
		labelBookings = new JLabel("Buchungen:");
		
		jtfVor = new JTextField();
		jtfName = new JTextField();
		
		buttonSearchGast = new JButton("Suchen...");
		
		geb = new JDateChooser();
		
		labelSearchGast.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane1.add(labelSearchGast);
		labelVor.setBounds(x_column1, y_line2, x_width, y_height);
		contentpane1.add(labelVor);
		labelName.setBounds(x_column1, y_line3, x_width, y_height);
		contentpane1.add(labelName);
		labelGeb.setBounds(x_column1, y_line4, x_width, y_height);
		contentpane1.add(labelGeb);
		
		jtfVor.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane1.add(jtfVor);
		jtfName.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane1.add(jtfName);
		setGebRoom(geb);
		geb.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane1.add(geb);
		
		buttonSearchGast.setBounds(x_column1, y_line5, x_width, y_height);
		buttonSearchGast.addActionListener(ButtonHandler);
		buttonSearchGast.setActionCommand("Search");
		contentpane1.add(buttonSearchGast);
		labelBookings.setBounds(x_column1, y_line6, x_width, y_height);
		contentpane1.add(labelBookings);
		contentpane1.setOpaque(true);
		contentpane1.setBackground(new Color(209,218,248));
		
		
		return contentpane1;
	}
}
