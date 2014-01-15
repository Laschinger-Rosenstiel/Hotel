package GUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class DataZimmer extends GUIHelp
{
	public JFrame jf, cf;
	private JButton b1,b2, b3;
	public JTextField jtf1, jtf2;
	public JComboBox cb;
	public String[] typ ={"Einzelzimmer","Doppelzimmer"};
	//add jtableview
	//public JTableview jtv;
	
	public DataZimmer()
	{
		//First JFrame
		jf = new JFrame();
		b1 = new JButton("Ändern");
		b1.setActionCommand("Change");
		b1.addActionListener(new ButtonHandlerDZ(this));
		b2 = new JButton("Löschen");
		b2.setActionCommand("Delete");
		b2.addActionListener(new ButtonHandlerDZ(this));
		b3 = new JButton("Anlegen");
		b3.setActionCommand("Create");
		b3.addActionListener(new ButtonHandlerDZ(this));
		//Second JFrame
		cf = new JFrame();
		cb = new JComboBox(typ);
	}
	
	public JPanel launchJFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		b1.setBounds(x_column2, y_line13, x_width, y_height);
		panel.add(b1);
		b2.setBounds(x_column4, y_line13, x_width, y_height);
		/*if(jtv == null)
		{
			//create new JTable
			jtv = new JTableView();
		}
		else
		{
			//update JTable
			jtv.updateJT();
		}
		 // 2. create JScrollPane with reference to the JTable
		JScrollPane scrollPane = new JScrollPane(jtv.getSQLTable());
		// 3. set bounds of the JTable with the JScrollPane
		scrollPane.setBounds(x_column1, y_line1, x_column5, y_line12);
		// 4. add JTable with JScrollPane to Jpanel
		panel.add(scrollPane); 
		*/
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
		
	}
}