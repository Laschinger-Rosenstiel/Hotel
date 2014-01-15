package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.CancelDl;
import GUI.CancelZimmer;

public class BHCancel implements ActionListener{

	CancelZimmer guiZimmer;
	CancelDl guiDl;
	
	public BHCancel (CancelZimmer guiZimmer) {
		this.guiZimmer = guiZimmer;
	}
	
	public BHCancel (CancelDl guiDl) {
		this.guiDl = guiDl;
	}

	public void actionPerformed(ActionEvent e) throws NullPointerException {
		
		System.out.println("Das Ereignis hat den Wert: " + e.getActionCommand());
		if (e.getActionCommand().equals("CancelZimmer?")) {
			int answer = JOptionPane.showConfirmDialog(null, "Dienstleistung wirklich buchen?", "Error",JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				System.out.println("Dienstleistung stornieren!");	
				
			}
		
		}
		else if (e.getActionCommand().equals("blabla")){
			
		}
	
	}
}