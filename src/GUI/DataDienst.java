package GUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Control.ButtonHandlerData;

public class DataDienst extends GUIHelp
{
	public JFrame jf, cf;
	private JButton b1,b2, b3, b4;
	public JTextField jtf1, jtf2, jtf3;
	public JLabel l1,l2,l3,l4;
	//public JComboBox cb;
	//public String[] typ ={"Einzelzimmer","Doppelzimmer"};
	//add jtableview
	//public JTableview jtv;
	
	public DataDienst()
	{
		//First JFrame
		jf = new JFrame();
		b1 = new JButton("Ändern");
		b1.setActionCommand("Change");
		b1.addActionListener(new ButtonHandlerData(this));
		b2 = new JButton("Löschen");
		b2.setActionCommand("Delete");
		b2.addActionListener(new ButtonHandlerData(this));
		b3 = new JButton("Anlegen");
		b3.setActionCommand("Create");
		b3.addActionListener(new ButtonHandlerData(this));
		l4 = new JLabel("Stammdaten Dienstleistung:", JLabel.LEFT);
		
		//Second JFrame
		cf = new JFrame();
		//cb = new JComboBox(typ);
		jtf1 = new JTextField(40);
		jtf2 = new JTextField(40);
		jtf3 = new JTextField(40);
		l1 = new JLabel("Dienstleistung:", JLabel.LEFT);
		l2 = new JLabel("Preis:", JLabel.LEFT);
		l3 = new JLabel("ID:", JLabel.LEFT);
		b4 = new JButton("Bestätigen");
		b4.setActionCommand("Confirme");
		b4.addActionListener(new ButtonHandlerData(this));
	}
	
	public JPanel launchJFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		l4.setBounds(x_column1, y_line1, x_width, y_height);
		panel.add(l4);
		b1.setBounds(x_column1, y_line13, x_width, y_height);
		panel.add(b1);
		b2.setBounds(x_column3, y_line13, x_width, y_height);
		panel.add(b2);
		b3.setBounds(x_column4, y_line13, x_width, y_height);
		panel.add(b3);
		
		panel.setOpaque(true);
		panel.setBackground(new Color(209,218,248));
		
		jf.add(panel);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		
		return panel;
	}
	
	public void launchCreateFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		l1.setBounds(x_column1, y_line1, x_width, y_height);
		panel.add(l1);
		jtf1.setBounds(x_column3, y_line1, x_width, y_height);
		panel.add(jtf1);
		l2.setBounds(x_column1, y_line2, x_width, y_height);
		panel.add(l2);
		jtf2.setBounds(x_column3, y_line2, x_width, y_height);
		panel.add(jtf2);
		l3.setBounds(x_column1, y_line3, x_width, y_height);
		panel.add(l3);
		jtf3.setBounds(x_column3, y_line3, x_width, y_height);
		panel.add(jtf3);
		b4.setBounds(x_column3, y_line4, x_width, y_height);
		panel.add(b4);
		//cb.setBounds(x_column4, y_line13, x_width, y_height);
		//panel.add(cb);
		panel.setOpaque(true);
		panel.setBackground(new Color(209,218,248));
		
		cf.add(panel);
		cf.setSize(600,500);
		cf.setLocation(300, 50);
		cf.setDefaultCloseOperation(cf.DISPOSE_ON_CLOSE);
		cf.setVisible(true);
				
	}
}