package control;
import gui.BookDl;
import gui.BookZimmer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Buchung;
import model.Dienstleistung;
import model.Gast;
import model.Zimmer;

public class BHBook extends BHHelp implements ActionListener{
	
	BookDl guiDl;
	BookZimmer guiZimmer;
	
	static Gast gast;
	static Buchung buchung;
	String tel;	
	
	public BHBook(BookZimmer bookZimmer) {
		this.guiZimmer = bookZimmer;
	}
	
	public BHBook(BookDl bookDl) {
		this.guiDl = bookDl;
	}
	
	public void actionPerformed(ActionEvent e) throws NullPointerException {
		
		System.out.println("Das Ereignis hat den Wert: " + e.getActionCommand());
		if (e.getActionCommand().equals("NewBooking")) {
			
			guiZimmer.launchJFrame();
			guiZimmer.cardLayout.show(this.guiZimmer.card, "Card1");
			
		}
		else if (e.getActionCommand().equals("NEXT")) {
			
			try {
				System.out.println(guiZimmer.getVorname());
				
				Gast gast = new Gast(guiZimmer.getVorname(), guiZimmer.getName(), guiZimmer.getStrasse(), guiZimmer.getHn(),
						guiZimmer.getPlz(), guiZimmer.getOrt(), guiZimmer.getLand(), "0", guiZimmer.getGeb());
				gast.setExisting(false);
				
				checkStringEmpty(gast.getVorname());
				checkStringEmpty(gast.getName());
				checkStringEmpty(gast.getStrasse());
				checkStringEmpty(gast.getHn());
				checkStringEmpty(gast.getPlz());
				checkStringEmpty(gast.getOrt());
				checkStringEmpty(gast.getLand());
				checkStringEmpty(guiZimmer.getTel2_1());
				checkStringEmpty(guiZimmer.getTel2_2());
				checkStringEmpty(guiZimmer.getTel2_3());
				checkNumber(gast.getPlz());
				checkBirthday(gast.getGeb());
				checkTel(guiZimmer.getTel2_1(), guiZimmer.getTel2_2(), guiZimmer.getTel2_3());			
				
				guiZimmer.contentpane3 = guiZimmer.launchSecond();	
				guiZimmer.labelVor3_2.setText(gast.getVorname());
				guiZimmer.labelName3_2.setText(gast.getName());
				guiZimmer.labelStr3_2.setText(gast.getStrasse() + " " + gast.getHn());
				guiZimmer.labelPlz3_2.setText(gast.getPlz());
				guiZimmer.labelOrt3_2.setText(gast.getOrt());
				guiZimmer.labelLand3_2.setText(gast.getLand());
								
				String Vorwahl = guiZimmer.getTel2_2();
				
				if (Vorwahl.charAt(0) == '0'){
						
					String[] splitResult = Vorwahl.split("0", 2);
					Vorwahl = splitResult[1];
				}
							
				guiZimmer.setTel(guiZimmer.getTel2_1() + " (0) "+ Vorwahl + " " + guiZimmer.getTel2_3());
				gast.setTel(guiZimmer.getTel());
				
				guiZimmer.labelTel3_2.setText(gast.getTel());
											
				SimpleDateFormat gebForm =new SimpleDateFormat("dd.MM.yyyy");
				String geb = gebForm.format(guiZimmer.getGeb());
				
				
				guiZimmer.labelGeb3_2.setText(geb);
				
				this.gast = gast;
							
				guiZimmer.card.add("Card2", guiZimmer.contentpane3);
				guiZimmer.cardLayout.show(this.guiZimmer.card, "Card2");
			}
			
			catch (GUIException gex){
			
					JOptionPane.showMessageDialog(null, gex, "Error",
				                                  JOptionPane.ERROR_MESSAGE);
			}
			
			catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(guiZimmer.jf, "Bitte alle Felder ausfüllen", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		else if (e.getActionCommand().equals("Available?")) {
			Date von = guiZimmer.getPickerVon();
			Date bis = guiZimmer.getPickerBis();
			
			
			String vonSql = getSQLDate(von);
			String bisSql = getSQLDate(bis);
			
			guiZimmer.availableZimmer = new JTableview("SELECT * from hotel.zimmer where hotel.zimmer.ZID not in (SELECT hotel.`zimmer-buchung`.ZID from hotel.`zimmer-buchung` where (Von between '"+vonSql+"' AND '"+bisSql+"') OR (Bis between '"+vonSql+"' AND '"+bisSql+"'))");
			JTable available = guiZimmer.availableZimmer.getSQLTable();
			
			guiZimmer.scrollPaneZimmer = new JScrollPane(available);
			guiZimmer.scrollPaneZimmer.setBounds(200, 280, 300, 100);
			guiZimmer.contentpane3.add(guiZimmer.scrollPaneZimmer);

			
		}
		else if (e.getActionCommand().equals("SEARCH")) {
			

			String gebSuche = "%";
			String vorSuche = "%";
			String nameSuche = "%";
			String gidSuche = "%";
			guiZimmer.sucheGast = null;
			
			try {
				gebSuche = getSQLDate(guiZimmer.getGebSuche());
			}
			catch (NullPointerException ex) {
				
			}
			
			
			if (!guiZimmer.getGidSuche().equals(""))
				gidSuche = guiZimmer.getGidSuche();
		
			
			if (!guiZimmer.getVornameSuche().equals(""))
				vorSuche = guiZimmer.getVornameSuche()+"%";
					
			if (!guiZimmer.getNameSuche().equals(""))
				nameSuche = guiZimmer.getNameSuche() +"%";
		
			
			String query = "Select * from hotel.gast where GID like '"+ gidSuche +"' AND Vorname like '"+vorSuche +
					"' AND Name like '" + nameSuche +"' AND Geburtstag like '" + gebSuche+"'";
			
			guiZimmer.sucheGast = new JTableview(query);
			
			JTable suche = guiZimmer.sucheGast.getSQLTable();
			
			guiZimmer.scrollPaneSuche.setVisible(false);
			guiZimmer.scrollPaneSuche = null;
			guiZimmer.scrollPaneSuche = new JScrollPane(suche);
			guiZimmer.scrollPaneSuche.setBounds(10, 360, 1000, 200);
			guiZimmer.contentpane1.add(guiZimmer.scrollPaneSuche);
			
		}
		
		else if (e.getActionCommand().equals("SEARCHDl")) {
			
			String gebSuche = "%";
			String vorSuche = "%";
			String nameSuche = "%";
			String gidSuche = "%";
			guiDl.sucheGast = null;
			
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
		
			String query = guiDl.getQuery() + " AND hotel.gast.GID like '"+gidSuche+"' AND hotel.gast.Vorname like '"+vorSuche+ "' AND hotel.gast.Name like'"+ nameSuche+"' AND hotel.gast.Geburtstag like '"+gebSuche+"'";
			
			
			guiDl.sucheGast = new JTableview(query);
			
			JTable suche = guiDl.sucheGast.getSQLTable();
			
			guiDl.scrollPaneSuche.setVisible(false);
			guiDl.scrollPaneSuche = null;
			guiDl.scrollPaneSuche = new JScrollPane(suche);
			guiDl.scrollPaneSuche.setBounds(10, 320, 1000, 200);
			guiDl.contentpane1.add(guiDl.scrollPaneSuche);
			
		}
		
		else if (e.getActionCommand().equals("ExistBooking")) {
			
			try {
			System.out.println("ExistBooking");	
			
			if (guiZimmer.sucheGast.getSQLTable().getSelectedRow() == -1) {
				 throw new GUIException("Fehler: Zeile nicht markiert!");
			}
			guiZimmer.launchJFrame();
			guiZimmer.contentpane3 = guiZimmer.launchSecond();
			
			int gid = Integer.parseInt((String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 0).toString());
			
		//	guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 0).toString();
			String vorname = (String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 1).toString();
			String name = (String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 2).toString();
			String strasse = (String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 3).toString();
			String hn = (String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 4).toString();
			String plz = (String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 5).toString();
			String ort = (String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 6).toString();
			String land = (String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 7).toString();
			String geb = getDateSqlToGer((String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 8).toString());
			String tel = (String) guiZimmer.sucheGast.getSQLTable().getValueAt(guiZimmer.sucheGast.getSQLTable().getSelectedRow(), 9).toString();
			
			SimpleDateFormat toDate = new SimpleDateFormat("dd.MM.yyyy");
			Date Geb = toDate.parse(geb);
			
			System.out.println(vorname);
			
			Gast exiGast = new Gast(vorname, name, strasse, hn, plz, ort, land, tel, Geb);
			exiGast.setExisting(true);
			exiGast.setGid(gid);
			System.out.println(exiGast.getVorname());
			
			guiZimmer.labelVor3_2.setText(exiGast.getVorname());
			guiZimmer.labelName3_2.setText(exiGast.getName());
			guiZimmer.labelStr3_2.setText(exiGast.getStrasse() + " "+ exiGast.getHn());
			guiZimmer.labelPlz3_2.setText(exiGast.getPlz());
			guiZimmer.labelOrt3_2.setText(exiGast.getOrt());
			guiZimmer.labelLand3_2.setText(exiGast.getLand());
			guiZimmer.labelTel3_2.setText(exiGast.getTel());
			
			SimpleDateFormat gebForm =new SimpleDateFormat("dd.MM.yyyy");
			guiZimmer.labelGeb3_2.setText(gebForm.format(exiGast.getGeb()));
			
			gast = exiGast;
			guiZimmer.card.add("Card2", guiZimmer.contentpane3);
			guiZimmer.cardLayout.show(this.guiZimmer.card, "Card2");
			}
			catch (GUIException gex) {
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		else if (e.getActionCommand().equals("BACK")) 
			guiZimmer.cardLayout.show(guiZimmer.card, "Card1");
		
		else if (e.getActionCommand().equals("BOOK?")) {
			
			try {
				checkBookingDate(guiZimmer.getPickerVon(), guiZimmer.getPickerBis());
				
				int answer = JOptionPane.showConfirmDialog(guiZimmer.jf, "Zimmer wirklich buchen?", "Error",JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
						
					if (guiZimmer.availableZimmer.getSQLTable().getSelectedRow() == -1) {
						 throw new GUIException("Fehler: Zeile nicht markiert!");
					}
					String ZID = (String) guiZimmer.availableZimmer.getSQLTable().getValueAt(guiZimmer.availableZimmer.getSQLTable().getSelectedRow(), 0).toString();
					
					Zimmer zimmer = new Zimmer(ZID);
					
					Buchung buchung = new Buchung(gast, zimmer, new Date());
					buchung.bookZimmer(guiZimmer.getPickerVon(), guiZimmer.getPickerBis());
					this.buchung = buchung;
					guiZimmer.launchThird();
				
					updateTable(guiZimmer.contentpane1, guiZimmer.scrollPaneSuche, guiZimmer.sucheGast, guiZimmer.getQuery(), guiZimmer.scrollPaneSuche.getX(), guiZimmer.scrollPaneSuche.getY(), guiZimmer.scrollPaneSuche.getWidth(), guiZimmer.scrollPaneSuche.getHeight());
					
					
					guiZimmer.card.add("Card3", guiZimmer.contentpane4);
					guiZimmer.cardLayout.show(this.guiZimmer.card, "Card3");
			}
			
			}
			catch (GUIException gex) {
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			}			
			catch (NullPointerException nex) {
				JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if (e.getActionCommand().equals("Dl buchen")){
			
			try{
				int answer = JOptionPane.showConfirmDialog(guiZimmer.jf, "Dienstleistung wirklich buchen?", "Error",JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					
				checkBookingDateDl(guiZimmer.bookDateDl.getDate());	
			
				if (guiZimmer.showDl.getSQLTable().getSelectedRow() == -1) {
					throw new GUIException("Fehler: Zeile nicht markiert!");
				} 
			
				guiZimmer.bookDateDl.getDate();
				buchung.getBid();
			
				int did = Integer.parseInt((String) guiZimmer.showDl.getSQLTable().getValueAt(guiZimmer.showDl.getSQLTable().getSelectedRow(), 0).toString());
				Dienstleistung dl = new Dienstleistung(did, guiZimmer.bookDateDl.getDate());
				buchung.bookDl(buchung, dl);
			}
			}
			catch (GUIException gex) {
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			}
			catch (NullPointerException nex) {
				JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen", "Error",
                        JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		else if (e.getActionCommand().equals("Dl cancel")){
			guiZimmer.jf.dispose();
			
		}
			
		
		else if (e.getActionCommand().equals("NewBookingDl")) {
			try {
				if (guiDl.sucheGast.getSQLTable().getSelectedRow() == -1) {
			
					throw new GUIException("Fehler: Zeile nicht markiert!");
				}
			
				String gid = (String) guiDl.sucheGast.getSQLTable().getValueAt(guiDl.sucheGast.getSQLTable().getSelectedRow(), 0).toString();
				String vorname = (String) guiDl.sucheGast.getSQLTable().getValueAt(guiDl.sucheGast.getSQLTable().getSelectedRow(), 1).toString();
				String name = (String) guiDl.sucheGast.getSQLTable().getValueAt(guiDl.sucheGast.getSQLTable().getSelectedRow(), 2).toString();
				String geb = getDateSqlToGer((String) guiDl.sucheGast.getSQLTable().getValueAt(guiDl.sucheGast.getSQLTable().getSelectedRow(), 3).toString());
				int bid = Integer.parseInt((String) guiDl.sucheGast.getSQLTable().getValueAt(guiDl.sucheGast.getSQLTable().getSelectedRow(), 4).toString());
				String zid = (String) guiDl.sucheGast.getSQLTable().getValueAt(guiDl.sucheGast.getSQLTable().getSelectedRow(), 5).toString();
				String von = (String) guiDl.sucheGast.getSQLTable().getValueAt(guiDl.sucheGast.getSQLTable().getSelectedRow(), 6).toString();
				String bis = (String) guiDl.sucheGast.getSQLTable().getValueAt(guiDl.sucheGast.getSQLTable().getSelectedRow(), 7).toString();
				
				
				SimpleDateFormat toDate = new SimpleDateFormat("dd.MM.yyyy");
				Date Geb = toDate.parse(geb);
			
				
				Gast gast = new Gast(Integer.parseInt(gid), vorname, name, Geb);
				Buchung buchung = new Buchung(bid);
				this.buchung = buchung;
				guiDl.launchJFrame();
				this.gast = gast;
				
				System.out.println(gid);
				guiDl.labelId2_2.setText(gid);
				guiDl.labelVor2_2.setText(vorname);
				guiDl.labelName2_2.setText(name);
				guiDl.labelZimmer2_2.setText(zid);
				guiDl.labelVon2_2.setText(von);
				guiDl.labelBis2_2.setText(bis);
				
			}
			catch (GUIException gex ){
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand().equals("BOOK?Dl")) {
			try {			
				checkBookingDateDl(guiDl.bookDate2.getDate());
				int answer = JOptionPane.showConfirmDialog(guiDl.jf, "Dienstleistung wirklich buchen?", "Error",JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.out.println("Dienstleistung buchen!");	
					if (guiDl.tableDl.getSQLTable().getSelectedRow() == -1) {
						 throw new GUIException("Fehler: Zeile nicht markiert!");
					}
					int did = Integer.parseInt((String) guiDl.tableDl.getSQLTable().getValueAt(guiDl.tableDl.getSQLTable().getSelectedRow(), 0).toString());
					
					Dienstleistung dl = new Dienstleistung(did, guiDl.bookDate2.getDate());
					
					buchung.bookDl(buchung, dl);
					
					guiDl.jf.dispose();
				}
			}
			catch (GUIException gex){
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			}
			catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(guiDl.jf, "Bitte alle Felder ausfüllen", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			
			
			}
		
		
	}	
}
	

