package control;

import gui.CancelDl;
import gui.CancelZimmer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Buchung;
import model.Gast;

public class BHCancel extends BHHelp implements ActionListener{

	CancelZimmer guiZimmer;
	CancelDl guiDl;
	static Buchung buchung;
	
	public BHCancel (CancelZimmer guiZimmer) {
		this.guiZimmer = guiZimmer;
	}
	
	public BHCancel (CancelDl guiDl) {
		this.guiDl = guiDl;
	}

	public void actionPerformed(ActionEvent e) throws NullPointerException {
		
		System.out.println("Das Ereignis hat den Wert: " + e.getActionCommand());
		if (e.getActionCommand().equals("CancelZimmer?")) {
			int answer = JOptionPane.showConfirmDialog(null, "Zimmerbuchung, sowie Dienstleistungsbuchungen und Gaststammdaten, so fern keine weitere Buchung vorhanden sind, löschen?", "Error",JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				try {
				
				if (guiZimmer.sucheBu.getSQLTable().getSelectedRow() == -1) {
 						throw new GUIException("Fehler: Zeile nicht markiert!");
				}		
				String Bid = (String) guiZimmer.sucheBu.getSQLTable().getValueAt(guiZimmer.sucheBu.getSQLTable().getSelectedRow(), 4).toString();
				int bid = Integer.parseInt(Bid);
				
				String Gid = (String) guiZimmer.sucheBu.getSQLTable().getValueAt(guiZimmer.sucheBu.getSQLTable().getSelectedRow(), 0).toString();
				int gid = Integer.parseInt(Gid);
				
				int anzahlBuchungen =Integer.parseInt(selectDB("SELECT count(GID) from hotel.buchung where GID = " + gid));
				
				if (anzahlBuchungen == 1){
					Gast gast = new Gast(gid);
					gast.deleteGast();
				}
				
				else {
				Buchung buchung = new Buchung(bid);
	
				buchung.cancelZimmer(buchung);
	
				
				}
				}
 				catch (GUIException gex) {
			
 					JOptionPane.showMessageDialog(null, gex, "Error",
 	                        JOptionPane.ERROR_MESSAGE);
				}
				
			}
					
			}
		
		
		else if (e.getActionCommand().equals("SearchBu")){
			String gebSuche = "%";
			String vorSuche = "%";
			String nameSuche = "%";
			String gidSuche = "%";
			guiZimmer.sucheBu = null;
			
			try {
				gebSuche = getSQLDate(guiZimmer.getGebSuche());
			}
			catch (NullPointerException ex) {
				
			}
			
			
			if (!guiZimmer.getGidSuche().equals(""))
				gidSuche = guiZimmer.getGidSuche();
		
			
			if (!guiZimmer.getVorSuche().equals(""))
				vorSuche = guiZimmer.getVorSuche()+"%";
			
			
		
			if (!guiZimmer.getNameSuche().equals(""))
				nameSuche = guiZimmer.getNameSuche() +"%";
		
			String query = guiZimmer.getQuery() + " AND hotel.gast.GID like '" + gidSuche + "' AND hotel.gast.Name like '" + nameSuche + "' AND hotel.gast.Vorname like '" + vorSuche + "' AND hotel.gast.Geburtstag like '"+gebSuche+"'";
			
			guiZimmer.sucheBu = new JTableview(query);
			
			JTable suche = guiZimmer.sucheBu.getSQLTable();
			
			guiZimmer.scrollPaneSuche.setVisible(false);
			guiZimmer.scrollPaneSuche = null;
			guiZimmer.scrollPaneSuche = new JScrollPane(suche);
			guiZimmer.scrollPaneSuche.setBounds(10, 280, 1000, 200);
			guiZimmer.contentpane1.add(guiZimmer.scrollPaneSuche);
		
		}
	
	}
}