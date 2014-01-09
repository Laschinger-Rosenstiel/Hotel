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
	JPanel panel;


	public ButtonHandlerLogin(LoginFrame lf)
	{
		this.lf = lf;

	}

	public ButtonHandlerLogin(JPanel panel)
	{
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) 
	{
		//System.out.println("Das Ereignis hat den Wert: " +e.getActionCommand());
		if (e.getActionCommand().equals("Change"))
		{
			//code
		}
		else if(e.getActionCommand().equals("Next"))
		{


			lf = new LoginFrame();
			String s = (String) lf.cb.getSelectedItem();
			if(s.equals("Rezeption"))
			{
				//System.out.println("Das Ereignis hat den Wert: " +e.getActionCommand());
				if (e.getActionCommand().equals("Next"))
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
