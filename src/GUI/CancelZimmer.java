package GUI;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Control.BHCancel;

public class CancelZimmer extends GUIHelp{
	
		BHCancel ButtonHandler = new BHCancel(this);
	//Startpanel
		private JPanel contentpane1;
		private JButton buttonCancelZimmer;
		private JLabel labelCancelZimmer; 
		
		
	public JPanel launchStartPanel(){
		//Objekte erzeugen
		contentpane1 = new JPanel();
		contentpane1.setLayout(null);

		labelCancelZimmer = new JLabel("Zimmerbuchung stornieren:");	
		
		buttonCancelZimmer = new JButton("Stornieren");
		buttonCancelZimmer.addActionListener(ButtonHandler);
		buttonCancelZimmer.setActionCommand("CancelZimmer?");
	
		
		labelCancelZimmer.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane1.add(labelCancelZimmer);
		
		//Color
		contentpane1.setOpaque(true);
		contentpane1.setBackground(new Color(209,218,248));
	
		return contentpane1;
	}

}
