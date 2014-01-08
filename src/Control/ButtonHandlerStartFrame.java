package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.BookZimmer;
import GUI.StartFrame;



	public class ButtonHandlerStartFrame implements ActionListener 
	{
		StartFrame s;
		JPanel panel;
		

		public ButtonHandlerStartFrame(StartFrame s)
		{
			this.s = s;

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
				System.out.println("Button2");
				s.launchStartFrame(bz.launchFirstJFrame());
				System.out.println("Button gedrückt");
			}



		}
	}

