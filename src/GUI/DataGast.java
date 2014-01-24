package GUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Control.ButtonHandlerData;

public class DataGast extends GUIHelp
{
	public JFrame jf;
	private JButton b1,b2;
	public JTextField tf1, tf2, tf3;
	private JLabel l1,l2,l3,l4;
	//add jtableview
	//public JTableview jtv;
	
	public DataGast()
	{
		jf = new JFrame();
		b1 = new JButton("Ändern");
		b1.setActionCommand("Change");
		b1.addActionListener(new ButtonHandlerData(this));
		b2 = new JButton("Suchen");
		b2.setActionCommand("Search");
		b2.addActionListener(new ButtonHandlerData(this));
		tf1 = new JTextField(40);
		tf2 = new JTextField(40);
		tf3 = new JTextField(40);
		l1 = new JLabel("Vorname:", JLabel.LEFT);
		l2 = new JLabel("Name:", JLabel.LEFT);
		l3 = new JLabel("Geburtsdatum:", JLabel.LEFT);
		l4 = new JLabel("Gastsuche:", JLabel.LEFT);
		
	}
	
	public JPanel launchJFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		l1.setBounds(x_column1, y_line2, x_width, y_height);
		panel.add(l1);
		l2.setBounds(x_column1, y_line3, x_width, y_height);
		panel.add(l2);
		l3.setBounds(x_column1, y_line4, x_width, y_height);
		panel.add(l3);
		l4.setBounds(x_column1, y_line1, x_width, y_height);
		panel.add(l4);
		tf1.setBounds(x_column3, y_line2, x_width, y_height);
		panel.add(tf1);
		tf2.setBounds(x_column3, y_line3, x_width, y_height);
		panel.add(tf2);
		tf3.setBounds(x_column3, y_line4, x_width, y_height);
		panel.add(tf3);
		b1.setBounds(x_column1, y_line13, x_width, y_height);
		panel.add(b1);
		b2.setBounds(x_column3, y_line13, x_width, y_height);
		panel.add(b2);
		panel.setOpaque(true);
		panel.setBackground(new Color(209,218,248));
		
		jf.add(panel);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		return panel;
	}
}