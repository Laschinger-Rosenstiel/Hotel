package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Control.ButtonHandlerData;
import Control.JTableview;

public class DataZimmer extends GUIHelp
{
	public JFrame createFrame;
	private JButton bChange,bDel, bCreate, bConfirme;
	public JTextField jtfZnr, jtfPreis;
	public JComboBox cb;
	public JLabel l1,l2,l3,l4;
	public String[] typ ={"Einzelzimmer","Doppelzimmer"};
	//add jtableview
	public JTableview jtv;
	public JPanel panel;
	public JScrollPane scrollPane;
	public JTable abc;
	
	public DataZimmer()
	{
		//First JFrame
		//jf = new JFrame();
		bChange = new JButton("Ändern");
		bChange.setActionCommand("Change");
		bChange.addActionListener(new ButtonHandlerData(this));
		bDel = new JButton("Löschen");
		bDel.setActionCommand("Delete");
		bDel.addActionListener(new ButtonHandlerData(this));
		bCreate = new JButton("Anlegen");
		bCreate.setActionCommand("Create");
		bCreate.addActionListener(new ButtonHandlerData(this));
		l4 = new JLabel("Stammdaten Zimmer:", JLabel.LEFT);
		
		
		
		//Second JFrame
		createFrame = new JFrame();
		cb = new JComboBox(typ);
		jtfZnr = new JTextField(40);
		jtfPreis = new JTextField(40);
		l1 = new JLabel("Zimmertyp:", JLabel.LEFT);
		l2 = new JLabel("Preis:", JLabel.LEFT);
		l3 = new JLabel("Zimmernr:", JLabel.LEFT);
		bConfirme = new JButton("Bestätigen");
		bConfirme.setActionCommand("Confirme");
		bConfirme.addActionListener(new ButtonHandlerData(this));
	}
	
	public JPanel launchJPanel()
	{
		
		panel = null;
		scrollPane = null;
		abc = null;
		jtv = null;
		
		panel = new JPanel();
		panel.setLayout(null);
		jtv = new JTableview("Select * from Zimmer");
		l4.setBounds(x_column1, y_line1, x_width, y_height);
		panel.add(l4);
		JTable abc = jtv.getSQLTable();
		scrollPane = new JScrollPane(abc); 
		scrollPane.setBounds(x_column1, y_line3, 600, 300); 
		panel.add(scrollPane);
		bChange.setBounds(x_column1, y_line13, x_width, y_height);
		panel.add(bChange);
		bDel.setBounds(x_column3, y_line13, x_width, y_height);
		panel.add(bDel);
		bCreate.setBounds(x_column4, y_line13, x_width, y_height);
		panel.add(bCreate);
		panel.setOpaque(true);
		panel.setBackground(new Color(209,218,248));
		
		/*jf.add(panel);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		*/
		return panel;
	}
	
	public void launchCreateFrame()
	{
		panel = new JPanel();
		panel.setLayout(null);
		l1.setBounds(x_column1, y_line2, x_width, y_height);
		panel.add(l1);
		cb.setBounds(x_column3, y_line2, x_width, y_height);
		panel.add(cb);
		l2.setBounds(x_column1, y_line3, x_width, y_height);
		panel.add(l2);
		jtfPreis.setBounds(x_column3, y_line3, x_width, y_height);
		panel.add(jtfPreis);
		l3.setBounds(x_column1, y_line4, x_width, y_height);
		panel.add(l3);
		jtfZnr.setBounds(x_column3, y_line4, x_width, y_height);
		panel.add(jtfZnr);
		bConfirme.setBounds(x_column3, y_line5, x_width, y_height);
		panel.add(bConfirme);
		
		panel.setOpaque(true);
		panel.setBackground(new Color(209,218,248));
		
		createFrame.add(panel);
		createFrame.setLocation(300, 50);
		createFrame.setSize(600,500);
		createFrame.setDefaultCloseOperation(createFrame.DISPOSE_ON_CLOSE);
		createFrame.setVisible(true);
				
	}
}