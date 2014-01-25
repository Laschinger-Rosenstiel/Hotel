package gui;

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

import control.ButtonHandlerData;
import control.JTableview;

public class DataZimmer extends GUIHelp
{
	public JFrame createFrame;
	private JButton bChange,bDel, bCreate, bConfirme;
	public JTextField jtfZnr, jtfPreis;
	public JComboBox cb;
	public JLabel l1,l2,l3,l4;
	public String[] typ ={"Einzelzimmer","Doppelzimmer"};
	public JTableview jtv;
	public JPanel panelZ1;
	public JPanel panelZ2;
	public JScrollPane scrollPaneZ;
	public JTable abc;
	private String x = "Zimmer";

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

		panelZ1 = new JPanel();
		panelZ1.setLayout(null);
		jtv = new JTableview("Select * from zimmer");
		JTable abc = jtv.getSQLTable();
		scrollPaneZ = new JScrollPane(abc); 
		scrollPaneZ.setBounds(x_column1, y_line3, 600, 300); 
		panelZ1.add(scrollPaneZ);
		l4.setBounds(x_column1, y_line1, x_width, y_height);
		panelZ1.add(l4);
		bChange.setBounds(x_column1, y_line13, x_width, y_height);
		panelZ1.add(bChange);
		bDel.setBounds(x_column3, y_line13, x_width, y_height);
		panelZ1.add(bDel);
		bCreate.setBounds(x_column4, y_line13, x_width, y_height);
		panelZ1.add(bCreate);
		panelZ1.setOpaque(true);
		panelZ1.setBackground(new Color(209,218,248));

		return panelZ1;
	}

	public void launchCreateFrame()
	{
		createFrame = null;
		panelZ2 = null;

		panelZ2 = new JPanel();
		panelZ2.setLayout(null);
		panelZ2.setVisible(false);
		l1.setBounds(x_column1, y_line2, x_width, y_height);
		panelZ2.add(l1);
		cb.setBounds(x_column3, y_line2, x_width, y_height);
		panelZ2.add(cb);
		l2.setBounds(x_column1, y_line3, x_width, y_height);
		panelZ2.add(l2);
		jtfPreis.setBounds(x_column3, y_line3, x_width, y_height);
		panelZ2.add(jtfPreis);
		l3.setBounds(x_column1, y_line4, x_width, y_height);
		panelZ2.add(l3);
		jtfZnr.setBounds(x_column3, y_line4, x_width, y_height);
		panelZ2.add(jtfZnr);
		bConfirme.setBounds(x_column3, y_line5, x_width, y_height);
		panelZ2.add(bConfirme);
		panelZ2.setOpaque(true);
		panelZ2.setBackground(new Color(209,218,248));
		panelZ2.setVisible(true);

		createFrame = new JFrame();
		createFrame.add(panelZ2);
		createFrame.setLocation(300, 50);
		createFrame.setSize(600,500);
		createFrame.setDefaultCloseOperation(createFrame.DISPOSE_ON_CLOSE);
		createFrame.setVisible(true);



	}
	public String getX()
	{
		return x;
	}
}