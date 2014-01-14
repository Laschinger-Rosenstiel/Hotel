/*package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import GUI.LoginFrame;
import GUI.StartFrame;



public class KeyListenerAll extends BHHelp implements KeyListener implements ActionListener
{
	LoginFrame lf;
	StartFrame sf;

	public KeyListenerAll(LoginFrame lf)
	{
		this.lf = lf;
	}


	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			try{
			
					checkStringEmpty(lf.jpf.getText());
					if(lf.jpf.getText().equals(lf.pw))
					{
						sf = new StartFrame();
						sf.launchStartFrame(sf.getJPanel2(), b);

					}

			}
			catch(GUIException gex)
			{
				JOptionPane.showMessageDialog(null, gex, "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub

	}

}
*/