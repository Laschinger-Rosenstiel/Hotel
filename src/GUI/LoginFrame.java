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
	public String[] konto = {"Rezeption", "Manager"};
	public String pw ="lala";
	public LoginFrame()
	{
		jf = new JFrame("Anmeldung");
		b1 = new JButton("Anmelden");
		b1.setActionCommand("Next");
		b1.addActionListener(new ButtonHandlerLogin(this));
		b2 = new JButton("Passwort ändern");
		b2.setActionCommand("Change");
		b2.addActionListener(new ButtonHandlerLogin(this));		
		l1 = new JLabel("Konto", JLabel.CENTER);
		l2 = new JLabel("Passwort", JLabel.CENTER);
		jtf = new JTextField(40);
		cb = new JComboBox(konto);
		//cb.setSelectedIndex(2);
		cb.addActionListener(new ButtonHandlerLogin(this));
	}
	
	public void launchLoginFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		l1.setBounds(10, 40,120, 30);
		panel.add(l1);
		cb.setBounds(350, 40, 120, 30);
		panel.add(cb);
		l2.setBounds(10, 80, 120, 30);
		panel.add(l2);
		jtf.setBounds(350, 80, 120, 30);
		panel.add(jtf);
		b2.setBounds(10, 120, 300, 30);
		panel.add(b2);
		b1.setBounds(350, 120, 300, 30);
		panel.add(b1);
		panel.setOpaque(true);
		panel.setBackground(new Color(209,218,248));
		jf.add(panel);
		jf.setSize(700, 300);
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

