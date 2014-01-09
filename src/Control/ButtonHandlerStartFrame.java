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
				s.launchStartFrame(new BookZimmer().launchStartPanel());
			}
		}
	}

