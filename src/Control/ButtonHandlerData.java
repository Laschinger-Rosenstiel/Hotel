package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.DataDienst;
import GUI.DataGast;
import GUI.DataZimmer;

public class ButtonHandlerData extends BHHelp implements ActionListener
{	
	DataGast dg;
	DataZimmer dz;
	DataDienst dd;
	
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
				
			}
			else if(e.getActionCommand().equals("Create"))
			{
				
			}
		}
		
		
	}

}
