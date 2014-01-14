package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.LoginFrame;
import GUI.StartFrame;




public class ButtonHandlerChange extends BHHelp implements ActionListener 
{
	LoginFrame cf;
	StartFrame sf;




	public ButtonHandlerChange(LoginFrame x)
	{
		cf = x;
	}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("BackToLogin"))
		{
			System.out.println("blub");
			cf.cf.setVisible(false);
		}
		else if(e.getActionCommand().equals("SavePw"))
		{
			try{
				checkStringEmpty(cf.jpf2.getText());
				checkStringEmpty(cf.jpf3.getText());
				checkStringEmpty(cf.jpf4.getText());
				checkLogin(cf.jpf4.getText(), cf.pw);
				checkLogin(cf.jpf2.getText(), cf.jpf3.getText());
				if(cf.jpf2.getText().equals(cf.jpf3.getText()) & cf.jpf4.getText().equals(cf.pw))
				{
					cf.setPw(cf.jpf2.getText());
					cf.launchLoginFrame();
					cf.cf.setVisible(false);
				}

			}
			catch(GUIException gex)
			{
				JOptionPane.showMessageDialog(null, gex, "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}
}	