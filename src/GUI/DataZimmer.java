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

public class DataZimmer extends GUIHelp
{
	public JFrame jf, cf;
	private JButton b1,b2, b3, b4;
	public JTextField jtf1, jtf2;
	public JComboBox cb;
	public JLabel l1,l2,l3;
	public String[] typ ={"Einzelzimmer","Doppelzimmer"};
	//add jtableview
	//public JTableview jtv;
	
	public DataZimmer()
	{
		//First JFrame
		jf = new JFrame();
		b1 = new JButton("�ndern");
		b1.setActionCommand("Change");
		b1.addActionListener(new ButtonHandlerDD(this));
		b2 = new JButton("L�schen");
		b2.setActionCommand("Delete");
		b2.addActionListener(new ButtonHandlerDD(this));
		b3 = new JButton("Anlegen");
		b3.setActionCommand("Create");
		b3.addActionListener(new ButtonHandlerDD(this));
		
		//Second JFrame
		cf = new JFrame();
		cb = new JComboBox(typ);
		jtf1 = new JTextField(40);
		jtf2 = new JTextField(40);
		l1 = new JLabel("Zimmertyp", JLabel.CENTER);
		l2 = new JLabel("Preis", JLabel.CENTER);
		l3 = new JLabel("Zimmernr", JLabel.CENTER);
		b4 = new JButton("Best�tigen");
		b4.setActionCommand("Confirme");
		b4.addActionListener(new ButtonHandlerDD(this));
	}
	
	public JPanel launchJFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		b1.setBounds(x_column2, y_line13, x_width, y_height);
		panel.add(b1);
		b2.setBounds(x_column4, y_line13, x_width, y_height);
		panel.add(b2);
		b3.setBounds(x_column4, y_line13, x_width, y_height);
		panel.add(b3);
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
		l1.setBounds(x_column1, y_line1, x_width, y_height);
		panel.add(l1);
		cb.setBounds(x_column2, y_line1, x_width, y_height);
		panel.add(cb);
		l2.setBounds(x_column1, y_line2, x_width, y_height);
		panel.add(l2);
		jtf1.setBounds(x_column2, y_line2, x_width, y_height);
		panel.add(jtf1);
		l3.setBounds(x_column1, y_line3, x_width, y_height);
		panel.add(l3);
		jtf2.setBounds(x_column2, y_line3, x_width, y_height);
		panel.add(jtf2);
		b4.setBounds(x_column2, y_line4, x_width, y_height);
		panel.add(b4);
		
		panel.setOpaque(true);
		panel.setBackground(new Color(209,218,248));
		
		cf.add(panel);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cf.setVisible(true);
				
	}
}