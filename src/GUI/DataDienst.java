package gui;

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

import control.ButtonHandlerData;
import control.JTableview;

public class DataDienst extends GUIHelp
{
	public JFrame createFrameD;
	private JButton bChange,bDel, bCreate, bConfirme;
	public JTextField jtfTyp, jtfPreis, jtfID;
	public JLabel lTyp,lPreis,lID,lTitel;
	//public JComboBox cb;
	//public String[] typ ={"Einzelzimmer","Doppelzimmer"};
	//add jtableview
	public JTableview jtvDienst;
	private String x = "Dienst";
	public JPanel panelD1;
	public JPanel panelD2;
	public JScrollPane scrollPaneD;
	public DataDienst()
	{
		//First JFrame
		
		bChange = new JButton("Ändern");
		bChange.setActionCommand("Change");
		bChange.addActionListener(new ButtonHandlerData(this));
		bDel = new JButton("Löschen");
		bDel.setActionCommand("Delete");
		bDel.addActionListener(new ButtonHandlerData(this));
		bCreate = new JButton("Anlegen");
		bCreate.setActionCommand("Create");
		bCreate.addActionListener(new ButtonHandlerData(this));
		lTitel = new JLabel("Dienstleistungen:", JLabel.LEFT);
		jtvDienst = new JTableview("Select * from dienstleistung");
		
		
		//Second JFrame
		createFrameD = new JFrame();
		//cb = new JComboBox(typ);
		jtfTyp = new JTextField(40);
		jtfPreis = new JTextField(40);
		jtfID = new JTextField(40);
		lTyp = new JLabel("Dienstleistung:", JLabel.LEFT);
		lPreis = new JLabel("Preis:", JLabel.LEFT);
		lID = new JLabel("ID:", JLabel.LEFT);
		bConfirme = new JButton("Bestätigen");
		bConfirme.setActionCommand("Confirme");
		bConfirme.addActionListener(new ButtonHandlerData(this));
	}
	
	public JPanel launchJPanel()
	{
		
		
		panelD1 = new JPanel();
		panelD1.setLayout(null);
		jtvDienst = new JTableview("Select * from dienstleistung");
		JTable dienstTab = jtvDienst.getSQLTable();
		scrollPaneD = new JScrollPane(dienstTab);
		scrollPaneD.setBounds(x_column1, y_line3, 600, 300); 
		panelD1.add(scrollPaneD);
		lTitel.setBounds(x_column1, y_line1, x_width, y_height);
		lTitel.setBounds(x_column1, y_line1, x_width, y_height);
		panelD1.add(lTitel);
		bChange.setBounds(x_column1, y_line13, x_width, y_height);
		panelD1.add(bChange);
		bDel.setBounds(x_column3, y_line13, x_width, y_height);
		panelD1.add(bDel);
		bCreate.setBounds(x_column4, y_line13, x_width, y_height);
		panelD1.add(bCreate);
		
		panelD1.setOpaque(true);
		panelD1.setBackground(new Color(209,218,248));
		
		return panelD1;
	}
	
	public JFrame launchCreateFrame()
	{
		createFrameD = null;
		panelD2 = null;
		
		JPanel panelD2 = new JPanel();
		panelD2.setLayout(null);
		panelD2.setVisible(false);
		lTyp.setBounds(x_column1, y_line1, x_width, y_height);
		panelD2.add(lTyp);
		jtfTyp.setBounds(x_column3, y_line1, x_width, y_height);
		panelD2.add(jtfTyp);
		lPreis.setBounds(x_column1, y_line2, x_width, y_height);
		panelD2.add(lPreis);
		jtfPreis.setBounds(x_column3, y_line2, x_width, y_height);
		panelD2.add(jtfPreis);
		lID.setBounds(x_column1, y_line3, x_width, y_height);
		panelD2.add(lID);
		jtfID.setBounds(x_column3, y_line3, x_width, y_height);
		panelD2.add(jtfID);
		bConfirme.setBounds(x_column3, y_line4, x_width, y_height);
		panelD2.add(bConfirme);
		//cb.setBounds(x_column4, y_line13, x_width, y_height);
		//panel.add(cb);
		panelD2.setOpaque(true);
		panelD2.setBackground(new Color(209,218,248));
		panelD2.setVisible(true);
		
		createFrameD = new JFrame();
		createFrameD.add(panelD2);
		createFrameD.setSize(600,500);
		createFrameD.setLocation(300, 50);
		createFrameD.setDefaultCloseOperation(createFrameD.DISPOSE_ON_CLOSE);
		createFrameD.setVisible(true);
		
		return createFrameD;
				
	}
	
	public String getX()
	{
		return x;
	}
}