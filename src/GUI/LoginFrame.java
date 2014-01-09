package GUI;

import java.awt.*;

import javax.swing.*;

import Control.ButtonHandlerLogin;

public class LoginFrame extends JFrame 
{
	public JFrame jf;
	private JButton b1,b2;
	public JLabel l1,l2;
	public JComboBox cb;
	public JTextField jtf;
	String[] konto = {"Rezeption", "Manager"};
	public String pw ="lala";
	public LoginFrame()
	{
		jf = new JFrame("Anmeldung");
		b1 = new JButton("Anmelden");
		b1.setActionCommand("Next");
		b1.addActionListener(new ButtonHandlerLogin(this));
		b2 = new JButton("Passwort ändern");
		b1.setActionCommand("Change");
		b1.addActionListener(new ButtonHandlerLogin(this));		
		l1 = new JLabel("Konto", JLabel.CENTER);
		l2 = new JLabel("Passwort", JLabel.CENTER);
		jtf = new JTextField(40);
		cb = new JComboBox(konto);
		cb.setSelectedIndex(2);
		cb.addActionListener(new ButtonHandlerLogin(this));
	}
	
	public void launchLoginFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		l1.setBounds(50, 50,150, 20);
		panel.add(l1);
		cb.setBounds(220, 50, 150, 20);
		panel.add(cb);
		l2.setBounds(50, 100, 150, 20);
		panel.add(l2);
		jtf.setBounds(220, 100, 150, 20);
		panel.add(jtf);
		b2.setBounds(100, 140, 50, 20);
		panel.add(b2);
		b1.setBounds(170, 140, 50, 20);
		jf.add(panel);
		jf.setSize(400, 400);
		jf.setLocation(200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		
	}
	public static void main(String[] args)
	{
		LoginFrame bla = new LoginFrame();
		bla.launchLoginFrame();
	}
}

