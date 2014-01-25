package gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.BHCancel;

public class CancelDl extends GUIHelp{
	
		BHCancel ButtonHandler = new BHCancel(this);
	//Startpanel
		private JPanel contentpane1;
		private JButton buttonCancelDl;
		private JLabel labelCancelDl; 
		
		
	public JPanel launchStartPanel(){
		//Objekte erzeugen
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);

		labelCancelDl = new JLabel("Dienstleistung stornieren:");	
		
		buttonCancelDl = new JButton("Stornieren");
		buttonCancelDl.addActionListener(ButtonHandler);
		buttonCancelDl.setActionCommand("CancelDl?");
		
		labelCancelDl.setBounds(x_column1, y_line1, 200, y_height);
		contentpane1.add(labelCancelDl);
		
		buttonCancelDl.setBounds(x_column1, y_line10, x_width, y_height);
		contentpane1.add(buttonCancelDl);
		
		//Color
		contentpane1.setOpaque(true);
		contentpane1.setBackground(new Color(209,218,248));
	
		return contentpane1;
	}
}
