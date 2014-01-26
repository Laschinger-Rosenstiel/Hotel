package control;

import gui.DataDienst;
import gui.DataGast;
import gui.DataZimmer;
import gui.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ButtonHandlerData extends BHHelp implements ActionListener
{	
	DataGast dg;
	DataZimmer dz;
	DataDienst dd;
	//ButtonHandlerStartFrame bh;
	StartFrame sf;


	public ButtonHandlerData(DataGast dg)
	{
		this.dg = dg;
	}
	public ButtonHandlerData(DataZimmer dz)
	{	
		this.dz = dz;
	}
	public ButtonHandlerData(DataDienst dd)
	{
		this.dd = dd;
	}



	public void actionPerformed(ActionEvent e)throws NullPointerException
	{

		if(dg!=null)
		{
			if(e.getActionCommand().equals("Change"))
			{

			}
			else if(e.getActionCommand().equals("Delete"))
			{

			}
		}
		else if(dz!=null)
		{
			if(e.getActionCommand().equals("Change"))
			{

			}
			else if(e.getActionCommand().equals("Create"))
			{
				System.out.println("ssfijwe");
				dz.launchCreateFrame();

			}
			else if(e.getActionCommand().equals("Delete"))
			{

				String id = (String) dz.jtv.getSQLTable().getValueAt(dz.jtv.getSQLTable().getSelectedRow(), 0).toString(); 

				String query = "DELETE from " + "zimmer" + " WHERE " + 
						"ZID" + " = '" + id + "'"; 
				writeDb(query); 
				dz.jtv = new JTableview("Select * From zimmer");
				JTable zimmer = dz.jtv.getSQLTable();
				dz.scrollPaneZ.setVisible(false);
				dz.scrollPaneZ = null;
				dz.scrollPaneZ = new JScrollPane(zimmer);
				dz.scrollPaneZ.setBounds(10, 120, 600, 300);
				dz.panelZ1.add(dz.scrollPaneZ);	 

			}
			else if(e.getActionCommand().equals("Confirme"))
			{
				try 
				{

					checkStringEmpty(dz.jtfZnr.getText());	
					writeDb("INSERT INTO zimmer (ZID, Typ, Preis)" + "VALUES('"+ dz.jtfZnr.getText() + 
							"', '"+ (String) dz.cb.getSelectedItem()+"', '"+ dz.jtfPreis.getText()+"')");

					dz.createFrame.dispose();
					dz.jtv = new JTableview("Select * From zimmer");
					JTable zimmer = dz.jtv.getSQLTable();
					dz.scrollPaneZ.setVisible(false);
					dz.scrollPaneZ = null;
					dz.scrollPaneZ = new JScrollPane(zimmer);
					dz.scrollPaneZ.setBounds(10, 120, 600, 300);
					dz.panelZ1.add(dz.scrollPaneZ);	 


				} 
				catch (GUIException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


		}


		else if(dd!=null)
		{
			if(e.getActionCommand().equals("Change"))
			{
				try {

					if(dd.jtvDienst.getSQLTable().getSelectedRow()== -1)
						throw new GUIException("Fehler: Zeile nicht markiert!");


					String id = (String) dd.jtvDienst.getSQLTable().getValueAt(dd.jtvDienst.getSQLTable().getSelectedRow(), 0).toString(); 
					String typ = (String) dd.jtvDienst.getSQLTable().getValueAt(dd.jtvDienst.getSQLTable().getSelectedRow(), 1).toString(); 
					String preis = (String) dd.jtvDienst.getSQLTable().getValueAt(dd.jtvDienst.getSQLTable().getSelectedRow(), 2).toString(); 

					dd.launchChangeFrameD(id,preis,typ );

				} catch (GUIException e1) 
				{
					JOptionPane.showMessageDialog(null, e1, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}



		}
		else if(e.getActionCommand().equals("Create"))
		{
			dd.launchCreateFrameD();
		}
		else if(e.getActionCommand().equals("Delete"))
		{
			String id = (String) dd.jtvDienst.getSQLTable().getValueAt(dd.jtvDienst.getSQLTable().getSelectedRow(), 0).toString(); 

			String query = "DELETE from " + "dienstleistung" + " WHERE " + 
					"DID" + " = '" + id + "'"; 
			writeDb(query); 
			dd.jtvDienst = new JTableview("Select * From dienstleistung");
			JTable dienst = dd.jtvDienst.getSQLTable();
			dd.scrollPaneD.setVisible(false);
			dd.scrollPaneD = null;
			dd.scrollPaneD = new JScrollPane(dienst);
			dd.scrollPaneD.setBounds(10, 120, 600, 300);
			dd.panelD1.add(dd.scrollPaneD);
		}
		else if(e.getActionCommand().equals("Confirme"))
		{
			try 
			{

				checkStringEmpty(dd.jtfTyp.getText());
				checkPrize(dd.jtfPreis.getText());
				checkID(dd.jtfID.getText());
				writeDb("INSERT INTO dienstleistung (DID, Bezeichnung, Preis)" + "VALUES('"+ dd.jtfID.getText() + 
						"', '"+ dd.jtfTyp.getText()+"', '"+ dd.jtfPreis.getText()+"')");

				dd.createFrameD.dispose();
				dd.jtvDienst = new JTableview("Select * From dienstleistung");
				JTable dienst = dd.jtvDienst.getSQLTable();
				dd.scrollPaneD.setVisible(false);
				dd.scrollPaneD = null;
				dd.scrollPaneD = new JScrollPane(dienst);
				dd.scrollPaneD.setBounds(10, 120, 600, 300);
				dd.panelD1.add(dd.scrollPaneD); 


			} 
			catch (GUIException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if(e.getActionCommand().equals("Confirme2"))
		{
			System.out.println("1");
			try 
			{

				System.out.println("1");
				checkStringEmpty(dd.jtfTyp2.getText());
				checkPrize(dd.jtfPreis2.getText());
				checkID(dd.jtfID2.getText());
				System.out.println("1");
				if(dd.jtvDienst.getSQLTable().getSelectedRow()== -1)
					throw new GUIException("Fehler: Zeile nicht markiert!");

				System.out.println("1");



				String id = (String) dd.jtvDienst.getSQLTable().getValueAt(dd.jtvDienst.getSQLTable().getSelectedRow(), 0).toString(); 
				String typ = (String) dd.jtvDienst.getSQLTable().getValueAt(dd.jtvDienst.getSQLTable().getSelectedRow(), 1).toString(); 
				String preis = (String) dd.jtvDienst.getSQLTable().getValueAt(dd.jtvDienst.getSQLTable().getSelectedRow(), 2).toString();

				writeDb("update dienstleistung set Bezeichnung = '" +typ +"',  Preis = '"+preis+"' where DID = '"+ id +"' ");


				//writeDb("update dienstleistung set ID = (select ID) Gesamtpreis = (select Preis from hotel.zimmer where ZID = '"+ ZID +"')*"+days+" where BID = "+BID);
				//writeDb("Update dienstleistung (DID, Bezeichnung, Preis)" + "VALUES('"+ dd.jtfID2.getText() + 
				//		"', '"+ dd.jtfTyp2.getText()+"', '"+ dd.jtfPreis2.getText()+"')");


				dd.changeFrameD.dispose();
				dd.jtvDienst = new JTableview("Select * From dienstleistung");
				JTable dienst = dd.jtvDienst.getSQLTable();
				dd.scrollPaneD.setVisible(false);
				dd.scrollPaneD = null;
				dd.scrollPaneD = new JScrollPane(dienst);
				dd.scrollPaneD.setBounds(10, 120, 600, 300);
				dd.panelD1.add(dd.scrollPaneD); 

			}


			catch (GUIException e1) {
				JOptionPane.showMessageDialog(null, e1, "Error",
						JOptionPane.ERROR_MESSAGE);

			}
		}	

	}


}



