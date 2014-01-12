package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BookDl;

public class BHBookDl implements ActionListener{

BookDl gui;
	
	public BHBookDl(BookDl bookDl) {
		this.gui = bookDl;
	}
	
	public void actionPerformed(ActionEvent e) throws NullPointerException {
		
		System.out.println("Das Ereignis hat den Wert: " + e.getActionCommand());
		if (e.getActionCommand().equals("NewBooking")) {
			
			gui.launchJFrame();
		
			
		}
		else if (e.getActionCommand().equals("NEXT")) {
		
		}
}
}
