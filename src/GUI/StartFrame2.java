package GUI;

import java.awt.*;

import javax.swing.*;

import Control.ButtonHandlerStartFrame;

public class StartFrame2 extends JFrame
{
	public JFrame sf;
	private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7,jb8, jb9; 
	public JLabel label1, label2, label3, label4, label5;
	boolean bu = false;
	JPanel p2, p3, p4;
	

	public StartFrame2()
	{ 
		// initialize new JFrames and gui objects

		sf = new JFrame("Mainframe");
		jb1 = new JButton("Zimmer");
		jb1.setActionCommand("Zimmer buchen");
		//jb1.addActionListener(new ButtonHandlerStartFrame(this));
		jb2 = new JButton("Dienstleistung");
		jb2.setActionCommand("Dl buchen");
		//jb2.addActionListener(new ButtonHandlerStartFrame(this));
		jb3 = new JButton("Zimmer");
		jb3.setActionCommand("Zimmer stornieren");
		//jb3.addActionListener(new ButtonHandlerStartFrame(this));
		jb4 = new JButton("Dienstleistung");
		jb4.setActionCommand("Dienstleistung stornieren");
		//jb4.addActionListener(new ButtonHandlerStartFrame(this));
		jb6 = new JButton("Verf�gbarkeit");
		jb6.setActionCommand("Verf�gbarkeit pr�fen");
		//jb6.addActionListener(new ButtonHandlerStartFrame(this));
		jb5 = new JButton("Preis");
		jb5.setActionCommand("Preis berechnen");
		//jb6.addActionListener(new ButtonHandlerStartFrame(this));
		jb7 = new JButton("Gast");
		jb7.setActionCommand("Gast anlegen");
		//jb7.addActionListener(new ButtonHandlerStartFrame(this));
		jb8 = new JButton("Zimmer");
		jb8.setActionCommand("Zimmer anlegen");
		//jb8.addActionListener(new ButtonHandlerStartFrame(this));
		jb9 = new JButton("Dienstleistung");
		jb9.setActionCommand("Dienstleistung anlegen");
		//jb9.addActionListener(new ButtonHandlerStartFrame(this));
		label1 = new JLabel("Buchen ", JLabel.CENTER);
		label2 = new JLabel("Stornieren ", JLabel.CENTER);
		label3 = new JLabel("Weitere ", JLabel.CENTER);
		label4 = new JLabel("Stammdaten ", JLabel.CENTER);
		label5 = new JLabel("Buchungssystem ", JLabel.CENTER);
		//gedogbneogbi

	}
	
	
	public JPanel getJPanel2()
	{
		p2 = new JPanel();
		p2.setLayout(null);
		label5.setBounds(250, 250, 500, 500);
		Font schriftart = new Font("Arial", Font.BOLD + Font.ITALIC, 30);
		label5.setFont(schriftart);
		p2.add(label5);
		p2.setOpaque(true);
		p2.setBackground(new Color(209,218,248));
		return p2;
	}
	
	public JPanel getJPanel3()
	{
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(4,1));
		p3.add(label4);
		p3.add(jb7);
		p3.add(jb8);
		p3.add(jb9);
		p3.setOpaque(true);
		p3.setBackground(new Color(155,193,225));
		
		return p3;
	}
	public JPanel getJPanel4()
	{
		p4 = new JPanel();
		p4.setLayout(new GridLayout(4,1));
		p4.setOpaque(true);
		p4.setBackground(new Color(155,193,225));
		return p4;
	}

	public void launchStartFrame2(JPanel a, JPanel b) //throws exception
	{
		if(a!=null & b!=null)
		{
			p2 = a;
			p3 = b;
		 
		//first panel
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(9,1));
		p1.add(label1);
		p1.add(jb1);
		p1.add(jb2);
		p1.add(label2);
		p1.add(jb3);
		p1.add(jb4);
		p1.add(label3);
		p1.add(jb5);
		p1.add(jb6);
		p1.setOpaque(true);
		p1.setBackground(new Color(155,193,225));
		//add panels to startframe
		sf.setLayout(new GridBagLayout());
		GridBagConstraints gc;
		gc = new GridBagConstraints();
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight = 9;
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.15;
		gc.weighty = 0.7;
		sf.add(p1,gc);
		//Panel2
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 5;
		gc.gridheight = 13;
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.85;
		gc.weighty = 1;
		sf.add(p2,gc);
		//Panel3
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 9;
		gc.gridwidth = 1;
		gc.gridheight = 4;
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.15;
		gc.weighty = 0.3;
		sf.add(p3,gc);
		sf.setExtendedState(sf.getExtendedState() | sf.MAXIMIZED_BOTH );
		sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sf.setVisible(true);
		
		}
		else
		{
			//exception
		}
	}

	

	public static void main(String[]args)
	{
		StartFrame2 startframe2 = new StartFrame2();
		startframe2.launchStartFrame2(startframe2.getJPanel2(), startframe2.getJPanel4());
	}
	

}