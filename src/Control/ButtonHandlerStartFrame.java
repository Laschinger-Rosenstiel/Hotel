package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.*;



	public class ButtonHandlerStartFrame implements ActionListener 
	{
		StartFrame sf;
		JPanel panel;
		

		public ButtonHandlerStartFrame(StartFrame sf)
		{
			this.sf = sf;

		}

		public ButtonHandlerStartFrame(JPanel panel)
		{
			this.panel = panel;
		}
		

		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("Das Ereignis hat den Wert: " +e.getActionCommand());
			if (e.getActionCommand().equals("Zimmer buchen"))
			{
				BookZimmer bz = new BookZimmer();
				System.out.println("vor ausführen bookzimmer()");
				sf.launchStartFrame(bz.launchStartPanel(),sf.getJPanel3());
				System.out.println("nach ausführen bookzimmer()");
			}
			else if (e.getActionCommand().equals("Dl buchen"))
			{
				sf.launchStartFrame(new BookDl().launchStartPanel(), sf.getJPanel3());
			}
			else if (e.getActionCommand().equals("Zimmer stornieren")){
				sf.launchStartFrame(new CancelZimmer().launchStartPanel(), sf.getJPanel3());
			}
			
		}
	}

