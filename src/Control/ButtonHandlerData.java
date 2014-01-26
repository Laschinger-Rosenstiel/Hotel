package control;

import gui.DataDienst;
import gui.DataGast;
import gui.DataZimmer;
import gui.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Gast;

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
		System.out.println("Das Ereignis hat den Wert: " + e.getActionCommand());

		if(dg!=null)
		{
			if(e.getActionCommand().equals("Change"))
			{
				try {

					if(dg.jtvGast.getSQLTable().getSelectedRow()== -1)
						throw new GUIException("Fehler: Zeile nicht markiert!");

					String id = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 0).toString(); 
					String vn = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 1).toString(); 
					String name = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 2).toString(); 
					String str = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 3).toString(); 
					String hnr = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 4).toString(); 
					String plz = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 5).toString(); 
					String ort = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 6).toString(); 
					String land = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 7).toString(); 
					String geb = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 8).toString(); 
					String tel = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 9).toString(); 


					dg.launchChangeFrameG(id,vn, name, str, hnr, plz, ort, land, tel, getDateSqlToGer(geb));


				} 
				catch (GUIException e1) 
				{
					JOptionPane.showMessageDialog(null, e1, "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
			else if(e.getActionCommand().equals("Search"))
			{
				String gebSuche = "";				
				try{
					gebSuche = getSQLDate(dg.Geb.getDate());
				}
				catch (NullPointerException nex){

				}

				String vn = dg.jtfVn.getText(); 
				String name = dg.jtfName.getText();

				String query = "Select * from gast where Vorname like '" + vn + "%' and Name like '" + name + "%' and Geburtstag like '" + gebSuche +"%'";
				System.out.println(query);
				dg.scrollPaneG.setVisible(false);
				dg.scrollPaneG = null;
				dg.jtvGast = new JTableview(query);
				JTable gast = dg.jtvGast.getSQLTable();
				dg.scrollPaneG = new JScrollPane(gast);
				dg.scrollPaneG.setBounds(10, 200, 600, 300);
				dg.panelG1.add(dg.scrollPaneG);


				/*	catch(NullPointerException ex)
					{

					}*/ 

			}
			else if (e.getActionCommand().equals("Confirme"))
			{
				System.out.println("Willi hat Unrecht");
				try
				{
					SimpleDateFormat toDate = new SimpleDateFormat("dd.MM.yyyy");
					Date Geb;
					Geb = toDate.parse(dg.jtfGeb2.getText());
					checkStringEmpty(dg.jtfVn2.getText());
					checkStringEmpty(dg.jtfName2.getText());
					checkStringEmpty(dg.jtfStr.getText());
					checkStringEmpty(dg.jtfHnr.getText());
					checkStringEmpty(dg.jtfPlz.getText());
					checkStringEmpty(dg.jtfOrt.getText());
					checkStringEmpty(dg.jtfLand.getText());
					checkStringEmpty(dg.jtfTel.getText());
					checkBirthday(Geb);
					Gast gast = new Gast(dg.id,dg.jtfVn2.getText(), dg.jtfName2.getText(), dg.jtfStr.getText(), dg.jtfHnr.getText(),dg.jtfPlz.getText(),
							dg.jtfOrt.getText(), dg.jtfLand.getText(), dg.jtfTel.getText(), Geb);
					gast.changeGast();
					dg.changeFrameG.dispose();
					dg.jtvGast = new JTableview("Select * From gast");
					JTable gtable = dg.jtvGast.getSQLTable();
					dg.scrollPaneG.setVisible(false);
					dg.scrollPaneG = null;
					dg.scrollPaneG = new JScrollPane(gtable);
					dg.scrollPaneG.setBounds(10, 200, 600, 300);
					dg.panelG1.add(dg.scrollPaneG); 


				}
				catch (GUIException e1) 
				{
					System.out.println("gui");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (ParseException e1) 
				{
					System.out.println("parse");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
			else if(e.getActionCommand().equals("Delete"))
			{
				try {
					if(dg.jtvGast.getSQLTable().getSelectedRow()== -1)

						throw new GUIException("Fehler: Zeile nicht markiert!");


					String id = (String) dg.jtvGast.getSQLTable().getValueAt(dg.jtvGast.getSQLTable().getSelectedRow(), 0).toString(); 

					String query = "DELETE from " + "gast" + " WHERE " + 
							"GID" + " = '" + id + "'"; 
					writeDb(query); 
					dg.jtvGast = new JTableview("Select * From gast");
					JTable gast = dg.jtvGast.getSQLTable();
					dg.scrollPaneG.setVisible(false);
					dg.scrollPaneG = null;
					dg.scrollPaneG = new JScrollPane(gast);
					dg.scrollPaneG.setBounds(10, 200, 600, 300);
					dg.panelG1.add(dg.scrollPaneG);	 
				}
				catch (GUIException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		}
		else if(dz!=null)
		{
			if(e.getActionCommand().equals("Change"))
			{
				try 
				{

					if(dz.jtv.getSQLTable().getSelectedRow()== -1)
						throw new GUIException("Fehler: Zeile nicht markiert!");


					String id = (String) dz.jtv.getSQLTable().getValueAt(dz.jtv.getSQLTable().getSelectedRow(), 0).toString(); 
					String typ = (String) dz.jtv.getSQLTable().getValueAt(dz.jtv.getSQLTable().getSelectedRow(), 1).toString(); 
					String preis = (String) dz.jtv.getSQLTable().getValueAt(dz.jtv.getSQLTable().getSelectedRow(), 2).toString(); 

					dz.launchChangeFrameZ(id,preis);
				} 
				catch (GUIException gex) 
				{
					JOptionPane.showMessageDialog(null, gex, "Error",
	                        JOptionPane.ERROR_MESSAGE);
				}

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
					JOptionPane.showMessageDialog(null, e1, "Error",
							JOptionPane.ERROR_MESSAGE);
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


}
