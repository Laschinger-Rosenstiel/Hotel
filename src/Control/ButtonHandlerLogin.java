package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import GUI.LoginFrame;
import GUI.StartFrame;




public class ButtonHandlerLogin implements ActionListener 
{
	LoginFrame lf;
	StartFrame sf;
	


	public ButtonHandlerLogin(LoginFrame lf)
	{
		this.lf = lf;

	}


	public void actionPerformed(ActionEvent e) 
	{
		//System.out.println("Das Ereignis hat den Wert: " +e.getActionCommand());
		if (e.getActionCommand().equals("Change"))
		{
			System.out.println("Passwort ändern");
		}
		else if(e.getActionCommand().equals("Next"))
		{


			sf = new StartFrame();
			System.out.println("1");
			String s = (String) lf.cb.getSelectedItem();
			System.out.println("2");
			if(s.equals("Rezeption"))
			{
				//System.out.println("Das Ereignis hat den Wert: " +e.getActionCommand());
				if(lf.jtf.getText().equals(lf.pw))
				{
					System.out.println("passwort überprüft");
					sf.launchStartFrame(sf.getJPanel2());
				}
				else
				{
					//exception
				}
			}
			else if(s.equals("Manager"))
			{
				if(lf.jtf.getText().equals("lala"))
				{
					sf.launchStartFrame(sf.getJPanel2());
				}
				else
				{
					//exception
				}
			}

		}
	}
}
