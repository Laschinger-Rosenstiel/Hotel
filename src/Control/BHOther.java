package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.CheckZimmer; 

public class BHOther extends BHHelp implements ActionListener{
	CheckZimmer guiZimmer;
	
	public BHOther (CheckZimmer guiZimmer) {
		this.guiZimmer = guiZimmer;
	}
	
	

	public void actionPerformed(ActionEvent e) throws NullPointerException {
		
		System.out.println("Das Ereignis hat den Wert: " + e.getActionCommand());
		if (e.getActionCommand().equals("Available?")) {
			
			try {
			checkBookingDate(guiZimmer.von.getDate(), guiZimmer.bis.getDate());
			}
			catch (GUIException gex) {
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			}
			catch (NullPointerException nex) {
				JOptionPane.showMessageDialog(null, "Datum eintragen", "Error",
                        JOptionPane.ERROR_MESSAGE);
			}			
		}
		
		else if (e.getActionCommand().equals("blabla")){

		}
	}
}