package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.LoginFrame;
import GUI.StartFrame;




public class ButtonHandlerLogin extends BHHelp implements ActionListener 
{
	LoginFrame lf;
	StartFrame sf;



	public ButtonHandlerLogin(LoginFrame lf)
	{
		this.lf = lf;

	}


	public void actionPerformed(ActionEvent e) throws NullPointerException
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
					try{
					//System.out.println("Das Ereignis hat den Wert: " +e.getActionCommand());
					if(lf.jpf.getText().equals(lf.pw))
					{
						System.out.println("passwort überprüft");
						sf.launchStartFrame(sf.getJPanel2(), sf.getJPanel4());
						//lf.setVisible(false);
					}
				}
				catch(GUIException gex)
				{
					JOptionPane.showMessageDialog(null, gex, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(s.equals("Manager"))
			{
				if(lf.jpf.getText().equals("lala"))
				{
					sf.launchStartFrame(sf.getJPanel2(), sf.getJPanel3());
					//lf.setVisible(false);
				}
				else
				{
					//exception
				}
			}

		}
	}
}
