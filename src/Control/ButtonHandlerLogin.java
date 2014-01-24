package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.LoginFrame;
import GUI.StartFrame;




public class ButtonHandlerLogin extends BHHelp implements ActionListener , KeyListener
{
	LoginFrame lf;
	StartFrame sf;
	
	
	String s;



	public ButtonHandlerLogin(LoginFrame x)
	{
		lf = x;
	}
	public ButtonHandlerLogin(StartFrame x)
	{
		sf = x;
	}




	public void actionPerformed(ActionEvent e) throws NullPointerException
	{
		//System.out.println("Das Ereignis hat den Wert: " +e.getActionCommand());
		if (e.getActionCommand().equals("Change"))
		{
			//System.out.println("Passwort ändern");
			lf.launchChangeFrame();
			//lf.jf.setVisible(false);
			//System.out.println("blob");
		}
		else if(e.getActionCommand().equals("BackToLogin"))
		{
			
			System.out.println("blub");
			lf.cf.dispose();
		}
		else if(e.getActionCommand().equals("SavePw"))
		{
			try{
				checkStringEmpty(lf.jpf2.getText());
				checkStringEmpty(lf.jpf3.getText());
				checkStringEmpty(lf.jpf4.getText());
				checkLogin(lf.jpf4.getText(), lf.pw);
				checkLogin(lf.jpf2.getText(), lf.jpf3.getText());
				if(lf.jpf2.getText().equals(lf.jpf3.getText()) & lf.jpf4.getText().equals(lf.pw))
				{
					lf.setPw(lf.jpf2.getText());
					lf.launchLoginFrame();
					lf.cf.dispose();
				}

			}
			catch(GUIException gex)
			{
				JOptionPane.showMessageDialog(null, gex, "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
		else if(e.getActionCommand().equals("Next"))
		{

			//sf = new StartFrame();
			//System.out.println("1");
			s = (String) lf.cb.getSelectedItem();
			//System.out.println(s);
			if(s.equals("Rezeption"))
			{
				try{

					checkStringEmpty(lf.jpf.getText());
					if(lf.jpf.getText().equals(lf.pw))
					{
						
						sf = new StartFrame();
						sf.setS(s);
						sf.launchStartFrame(sf.getJPanel2(), sf.getJPanel4());
						lf.jf.dispose();
						
					}
					else
					{
						try{
							checkLogin(lf.pw, lf.jpf.getText());
						}
						catch(GUIException gex)
						{
							JOptionPane.showMessageDialog(null, gex, "Error",
									JOptionPane.ERROR_MESSAGE);
						}
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

				try{

					checkStringEmpty(lf.jpf.getText());
					if(lf.jpf.getText().equals(lf.pw))
					{
						sf = new StartFrame();
						sf.setS(s);
						sf.launchStartFrame(sf.getJPanel2(), sf.getJPanel3());
						lf.jf.dispose();
					}
					else
					{
						try{
							checkLogin(lf.pw, lf.jpf.getText());
						}
						catch(GUIException gex)
						{
							JOptionPane.showMessageDialog(null, gex, "Error",
									JOptionPane.ERROR_MESSAGE);
						}
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





	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			//sf = new StartFrame();
			String s = (String) lf.cb.getSelectedItem();
			if(s.equals("Rezeption"))
			{
				try{

					checkStringEmpty(lf.jpf.getText());
					if(lf.jpf.getText().equals(lf.pw))
					{
						sf = new StartFrame();
						sf.setS(s);
						sf.launchStartFrame(sf.getJPanel2(), sf.getJPanel4());
						lf.jf.dispose();
					}
					else
					{
						try{
							checkLogin(lf.pw, lf.jpf.getText());
						}
						catch(GUIException gex)
						{
							JOptionPane.showMessageDialog(null, gex, "Error",
									JOptionPane.ERROR_MESSAGE);
						}
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

				try{

					checkStringEmpty(lf.jpf.getText());
					if(lf.jpf.getText().equals(lf.pw))
					{
						sf = new StartFrame();
						sf.setS(s);
						sf.launchStartFrame(sf.getJPanel2(), sf.getJPanel3());
						lf.jf.dispose();
					}
					else
					{
						try{
							checkLogin(lf.pw, lf.jpf.getText());
						}
						catch(GUIException gex)
						{
							JOptionPane.showMessageDialog(null, gex, "Error",
									JOptionPane.ERROR_MESSAGE);
						}
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

