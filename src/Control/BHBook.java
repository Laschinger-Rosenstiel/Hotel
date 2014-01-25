package control;
import gui.BookDl;
import gui.BookZimmer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Gast;

public class BHBook extends BHHelp implements ActionListener{
	
	BookZimmer guiZimmer;
	BookDl guiDl;
	static Gast newGast = new Gast();
	Gast existGast;
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
						
				System.out.println(gast.getVorname());
				
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
				System.out.println("Geburtstag: " + geb);
				
				guiZimmer.labelGeb3_2.setText(geb);
				
				newGast = gast;
							
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
			guiZimmer.scrollPaneZimmer.setBounds(300, 280, 300, 100);
			guiZimmer.contentpane3.add(guiZimmer.scrollPaneZimmer);			
		}
		else if (e.getActionCommand().equals("SEARCH")) {
			
			if (guiZimmer.getVornameSuche().equals(""))
			
			
			guiZimmer.sucheGast = new JTableview("Select * From hotel.gast where gid = 2");
			JTable suche = guiZimmer.sucheGast.getSQLTable();
			
			guiZimmer.scrollPaneSuche.setVisible(false);
			guiZimmer.scrollPaneSuche = null;
			guiZimmer.scrollPaneSuche = new JScrollPane(suche);
			guiZimmer.scrollPaneSuche.setBounds(10, 320, 1000, 200);
			guiZimmer.contentpane1.add(guiZimmer.scrollPaneSuche);
			
		}
		
		
		else if (e.getActionCommand().equals("ExistBooking")) {
			System.out.println("ExistBooking");	
			/*gui.labelVor3_2.setText();
			gui.labelName3_2.setText(gui.jtfName2.getText());
			gui.labelStr3_2.setText(gui.jtfStr2.getText() + " " + gui.jtfHn2.getText());
			gui.labelPlz3_2.setText(gui.jtfPlz2.getText());
			gui.labelOrt3_2.setText(gui.jtfOrt2.getText());
			gui.labelLand3_2.setText(gui.jtfLand2.getText());
							
			String Vorwahl = gui.jtfTel2_2.getText();
			
		
			gui.labelTel3_2.setText(gui.jtfTel2_1.getText() + " (0) "+ Vorwahl + " " + gui.jtfTel2_3.getText());
			
			
			
			
			SimpleDateFormat geb2 =new SimpleDateFormat("dd.MM.yyyy");
			String geb = geb2.format(gui.geb2.getDate());
			gui.labelGeb3_2.setText(geb);
			*/			
			guiZimmer.launchJFrame();
			guiZimmer.contentpane3 = guiZimmer.launchSecond();	
			guiZimmer.card.add("Card2", guiZimmer.contentpane3);
			guiZimmer.cardLayout.show(this.guiZimmer.card, "Card2");
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
					System.out.println(newGast.getVorname());			
					int GID = writeDbAi("INSERT INTO gast (Vorname, Name, Strasse, Hausnummer, Postleitzahl, Ort, Land, Telefonnummer, Geburtstag) " + "VALUES('"+ newGast.getVorname() + 
							"', '"+ newGast.getName() +"', '"+ newGast.getStrasse() +"', '"+ newGast.getHn()+"', "+ newGast.getPlz()+", '"
							+newGast.getOrt()+"', '"+ newGast.getLand() +"', '"+ newGast.getTel()+"', '"+ getSQLDate(guiZimmer.getGeb())+"')"); 
					
					int BID = writeDbAi("INSERT INTO buchung (GID, Erfassungsdatum) VALUES("+GID+", '" + getSQLDate(new Date()) + "')");
					
					writeDbAi("INSERT INTO hotel.`zimmer-buchung` (BID, ZID, Von, Bis) VALUES("+BID+", "+ZID+
					", '" + getSQLDate(guiZimmer.getPickerVon()) + "', '" + getSQLDate(guiZimmer.getPickerBis())+"')");
									
					guiZimmer.jf.dispose();
					
					
					Calendar von = new GregorianCalendar();
					Calendar bis = new GregorianCalendar();
					von = guiZimmer.pickerVon.getCalendar();
					bis = guiZimmer.pickerBis.getCalendar();
					
					long time = bis.getTime().getTime() - von.getTime().getTime();  // Differenz in ms
					long days = Math.round( (double)time / (24. * 60.*60.*1000.) );     // Differenz in Tagen
					
					writeDb("update hotel.buchung set Gesamtpreis = (select Preis from hotel.zimmer where ZID = '"+ ZID +"')*"+days+" where BID = "+BID);
				
					
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
		
		else if (e.getActionCommand().equals("NewBookingDl")) {
			
			guiDl.launchJFrame();
		
			
		}
		else if (e.getActionCommand().equals("BOOK?Dl")) {
			try {			
				checkBookingDateDl(guiDl.bookDate2.getDate());
				int answer = JOptionPane.showConfirmDialog(guiDl.jf, "Dienstleistung wirklich buchen?", "Error",JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.out.println("Dienstleistung buchen!");	
					guiDl.jf.dispose();
				}
			}
			catch (GUIException gex){
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			}
			catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(guiDl.jf, "Bitte Buchungsdatum eintragen", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			
			
			}
		
		
	}	
}
	

