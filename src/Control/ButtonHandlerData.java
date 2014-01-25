package control;

import gui.DataDienst;
import gui.DataGast;
import gui.DataZimmer;
import gui.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandlerData extends BHHelp implements ActionListener
{	
	DataGast dg;
	DataZimmer dz;
	DataDienst dd;
	ButtonHandlerStartFrame bh;
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
			else if(e.getActionCommand().equals("Delete"))
			{
				
				String id = (String) dz.jtv.getSQLTable().getValueAt(dz.jtv.getSQLTable().getSelectedRow(), 0).toString(); 

				String query = "DELETE from " + "zimmer" + " WHERE " + 
						"ZID" + " = '" + id + "'"; 
						 writeDB(query); 
						 dz.launchJPanel(); 
						
						  
						 } 

			}
			else if(e.getActionCommand().equals("Create"))
			{
				dz.launchCreateFrame();
								
			}
			else if(e.getActionCommand().equals("Confirme"))
			{
				try 
				{
					checkStringEmpty(dz.jtfZnr.getText());
					//checkNumber(dz.jtfPreis.getText());
					
					writeDB("INSERT INTO zimmer (ZID, Typ, Preis)" + "VALUES('"+ dz.jtfZnr.getText() + 
							"', '"+ (String) dz.cb.getSelectedItem()+"', '"+ dz.jtfPreis.getText()+"')");
					//dz.jtv = null;
					//DataZimmer dz2 = new DataZimmer();
					//dz2.launchJPanel();
					dz.launchJPanel();
					
					dz.createFrame.dispose();
					
					
				} 
				catch (GUIException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		else if(dd!=null)
		{
			if(e.getActionCommand().equals("Change"))
			{
				
			}
			else if(e.getActionCommand().equals("Delete"))
			{
				
			}
			else if(e.getActionCommand().equals("Create"))
			{
				dd.launchCreateFrame();
			}
			else if(e.getActionCommand().equals("Confirme"))
			{
				
			}
		}
		
		
	}


}
