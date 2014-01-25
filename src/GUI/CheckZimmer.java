package gui;
import java.awt.Color;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import control.BHOther;

public class CheckZimmer extends GUIHelp{

			BHOther ButtonHandler = new BHOther(this);
		//Startpanel
			private JPanel contentpane1;
			private JButton buttonCheck;
			private JLabel labelZeitraum, labelVon, labelBis, labelZimmer; 
			public JDateChooser von, bis;
			
			
		public JPanel launchStartPanel(){
			//Objekte erzeugen
			contentpane1 = new JPanel();
			contentpane1.setLayout(null);

			labelZeitraum = new JLabel("Zeitraum:");
			labelVon = new JLabel("Von:");
			labelBis = new JLabel("Bis:");
			labelZimmer = new JLabel("Verfügbare Zimmer:");
			
			von = new JDateChooser();
			bis = new JDateChooser();
			
			buttonCheck = new JButton("Verfügbarkeit prüfen...");
			
			buttonCheck.addActionListener(ButtonHandler);
			buttonCheck.setActionCommand("Available?");
			
			labelZeitraum.setBounds(x_column1, y_line1, x_width, y_height);
			contentpane1.add(labelZeitraum);
			labelVon.setBounds(x_column1, y_line2, x_width, y_height);
			contentpane1.add(labelVon);
			labelBis.setBounds(x_column1, y_line3, x_width, y_height);
			contentpane1.add(labelBis);
			
			von.setBounds(x_column2, y_line2, x_width, y_height);
			von.setSelectableDateRange(new Date(), null);
			contentpane1.add(von);
			bis.setBounds(x_column2, y_line3, x_width, y_height);
			bis.setSelectableDateRange(new Date(), null);
			contentpane1.add(bis);
			buttonCheck.setBounds(x_column1, y_line4, 180, y_height);
			contentpane1.add(buttonCheck);
			
			
			labelZimmer.setBounds(x_column1, y_line5, x_width, y_height);
			contentpane1.add(labelZimmer);
			
			//Color
			contentpane1.setOpaque(true);
			contentpane1.setBackground(new Color(209,218,248));
		
			return contentpane1;
		}
}
