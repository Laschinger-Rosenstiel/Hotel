package control;

import gui.CancelDl;
import gui.CancelZimmer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Buchung;
import model.Dienstleistung;
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
		
		else if (e.getActionCommand().equals("CancelDl?")) {
			
			int answer = JOptionPane.showConfirmDialog(null, "Dienstleistungen wirklich löschen?", "Error",JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				try {
				
				if (guiDl.sucheBu.getSQLTable().getSelectedRow() == -1) {
 						throw new GUIException("Fehler: Zeile nicht markiert!");
				}		
				String Bid = (String) guiDl.sucheBu.getSQLTable().getValueAt(guiDl.sucheBu.getSQLTable().getSelectedRow(), 4).toString();
				int bid = Integer.parseInt(Bid);
				
				String Dlbid = (String) guiDl.sucheBu.getSQLTable().getValueAt(guiDl.sucheBu.getSQLTable().getSelectedRow(), 5).toString();
				int dlbid = Integer.parseInt(Dlbid);
				
				String a = selectDB("select hotel.`dl-buchung`.DID from hotel.`dl-buchung` where hotel.`dl-buchung`.dlbid = " +dlbid);
				Dienstleistung dl = new Dienstleistung(Integer.parseInt(a));
				Buchung buchung = new Buchung(bid);
				buchung.setDlbid(dlbid);
				buchung.cancelDl(buchung, dl);
				
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
			System.out.println(query);
			guiZimmer.sucheBu = new JTableview(query);
			
			JTable suche = guiZimmer.sucheBu.getSQLTable();
			
			guiZimmer.scrollPaneSuche.setVisible(false);
			guiZimmer.scrollPaneSuche = null;
			guiZimmer.scrollPaneSuche = new JScrollPane(suche);
			guiZimmer.scrollPaneSuche.setBounds(10, 280, 1000, 200);
			guiZimmer.contentpane1.add(guiZimmer.scrollPaneSuche);
		
		}
		
		else if (e.getActionCommand().equals("SearchDl")){
			String gebSuche = "%";
			String vorSuche = "%";
			String nameSuche = "%";
			String gidSuche = "%";
			guiDl.sucheBu = null;
			
			try {
				gebSuche = getSQLDate(guiDl.getGebSuche());
			}
			catch (NullPointerException ex) {
				
			}
			
			
			if (!guiDl.getGidSuche().equals(""))
				gidSuche = guiDl.getGidSuche();
		
			
			if (!guiDl.getVorSuche().equals(""))
				vorSuche = guiDl.getVorSuche()+"%";
			
			
		
			if (!guiDl.getNameSuche().equals(""))
				nameSuche = guiDl.getNameSuche() +"%";
		
			String query = guiDl.getQuery() + " AND hotel.gast.GID like '" + gidSuche + "' AND hotel.gast.Name like '" + nameSuche + "' AND hotel.gast.Vorname like '" + vorSuche + "' AND hotel.gast.Geburtstag like '"+gebSuche+"'";
			
			guiDl.sucheBu = new JTableview(query);
			
			JTable suche = guiDl.sucheBu.getSQLTable();
			
			guiDl.scrollPaneSuche.setVisible(false);
			guiDl.scrollPaneSuche = null;
			guiDl.scrollPaneSuche = new JScrollPane(suche);
			guiDl.scrollPaneSuche.setBounds(10, 280, 1000, 200);
			guiDl.contentpane1.add(guiDl.scrollPaneSuche);
		
		}
				
				

	}		
	
	}
