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
	private Gast newGast = new Gast();
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
				newGast.setVorname(guiZimmer.getVorname());
				newGast.setName(guiZimmer.getName());
				newGast.setStrasse(guiZimmer.getStrasse());	
				newGast.setHn(guiZimmer.getHn());
				newGast.setPlz(guiZimmer.getPlz());
				newGast.setOrt(guiZimmer.getOrt());
				newGast.setLand(guiZimmer.getLand());
				newGast.setGeb(guiZimmer.getGeb());
				
				System.out.println(newGast.getVorname());
				
				checkStringEmpty(newGast.getVorname());
				checkStringEmpty(newGast.getName());
				checkStringEmpty(newGast.getStrasse());
				checkStringEmpty(newGast.getHn());
				checkStringEmpty(newGast.getPlz());
				checkStringEmpty(newGast.getOrt());
				checkStringEmpty(newGast.getLand());
				checkStringEmpty(guiZimmer.getTel2_1());
				checkStringEmpty(guiZimmer.getTel2_2());
				checkStringEmpty(guiZimmer.getTel2_3());
				checkNumber(newGast.getPlz());
				checkBirthday(newGast.getGeb());
				checkTel(guiZimmer.getTel2_1(), guiZimmer.getTel2_2(), guiZimmer.getTel2_3());			
				
				guiZimmer.contentpane3 = guiZimmer.launchSecond();	
				guiZimmer.labelVor3_2.setText(newGast.getVorname());
				guiZimmer.labelName3_2.setText(newGast.getName());
				guiZimmer.labelStr3_2.setText(newGast.getStrasse() + " " + newGast.getHn());
				guiZimmer.labelPlz3_2.setText(newGast.getPlz());
				guiZimmer.labelOrt3_2.setText(newGast.getOrt());
				guiZimmer.labelLand3_2.setText(newGast.getLand());
								
				String Vorwahl = guiZimmer.getTel2_2();
				
				if (Vorwahl.charAt(0) == '0'){
						
					String[] splitResult = Vorwahl.split("0", 2);
					Vorwahl = splitResult[1];
				}
							
				guiZimmer.setTel(guiZimmer.getTel2_1() + " (0) "+ Vorwahl + " " + guiZimmer.getTel2_3());
				newGast.setTel(guiZimmer.getTel());
				
				guiZimmer.labelTel3_2.setText(newGast.getTel());
											
				SimpleDateFormat geb2 =new SimpleDateFormat("dd.MM.yyyy");
				String geb = geb2.format(newGast.getGeb());
				guiZimmer.labelGeb3_2.setText(geb);
							
				guiZimmer.card.add("Card2", guiZimmer.contentpane3);
				guiZimmer.cardLayout.show(this.guiZimmer.card, "Card2");
			}
			
			catch (GUIException gex){
			
					JOptionPane.showMessageDialog(null, gex, "Error",
				                                  JOptionPane.ERROR_MESSAGE);
			}
			
			/*catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(guiZimmer.jf, "Bitte Geburtstag eintragen", "Error",
						JOptionPane.ERROR_MESSAGE);
			}*/
		}
		
		else if (e.getActionCommand().equals("Available?")) {
			Date von = guiZimmer.getPickerVon();
			Date bis = guiZimmer.getPickerBis();
			
			
			String vonSql = getSQLDate(von);
			String bisSql = getSQLDate(bis);
			
			guiZimmer.availableZimmer = new JTableview("SELECT * from hotel.zimmer where hotel.zimmer.ZID not in (SELECT hotel.`zimmer-buchung`.ZID from hotel.`zimmer-buchung` where (Von between '"+vonSql+"' AND '"+bisSql+"') OR (Bis between '"+vonSql+"' AND '"+bisSql+"'))");
			JTable available = guiZimmer.availableZimmer.getSQLTable();
			
			guiZimmer.scrollPane = new JScrollPane(available);
			guiZimmer.scrollPane.setBounds(300, 280, 300, 100);
			guiZimmer.contentpane3.add(guiZimmer.scrollPane);			
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
							+newGast.getOrt()+"', '"+ newGast.getLand() +"', '"+ newGast.getTel()+"', '"+ getSQLDate(newGast.getGeb())+"')"); 
					
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
		/*	catch (NullPointerException nex) {
				JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}*/
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
	

