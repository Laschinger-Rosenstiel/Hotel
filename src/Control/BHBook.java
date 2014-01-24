package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import GUI.BookDl;
import GUI.BookZimmer;

public class BHBook extends BHHelp implements ActionListener{
	
	BookZimmer guiZimmer;
	BookDl guiDl;
	
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
				/*checkStringEmpty(guiZimmer.jtfVorname2.getText());
				checkStringEmpty(guiZimmer.jtfName2.getText());
				checkStringEmpty(guiZimmer.jtfStr2.getText());
				checkStringEmpty(guiZimmer.jtfHn2.getText());
				checkStringEmpty(guiZimmer.jtfPlz2.getText());
				checkStringEmpty(guiZimmer.jtfOrt2.getText());
				checkStringEmpty(guiZimmer.jtfTel2_1.getText());
				checkStringEmpty(guiZimmer.jtfTel2_2.getText());
				checkStringEmpty(guiZimmer.jtfTel2_3.getText());
				checkNumber(guiZimmer.jtfPlz2.getText());
				checkBirthday(guiZimmer.geb2.getDate());
				checkTel(guiZimmer.jtfTel2_1.getText(), guiZimmer.jtfTel2_2.getText(), guiZimmer.jtfTel2_3.getText());			
				*/
				
				WriteDB wdb = new WriteDB("INSERT INTO gast (Vorname, Name, Strasse, Hausnummer, PLZ, ORT)" + "VALUES('"+ guiZimmer.jtfVorname2.getText() + 
						"', '"+ guiZimmer.jtfName2.getText()+"', '"+guiZimmer.jtfStr2.getText()+"', '"+guiZimmer.jtfHn2.getText()+"', '"+guiZimmer.jtfPlz2.getText()+"', '"+
				guiZimmer.jtfOrt2.getText()+"')"); 

				
				guiZimmer.contentpane3 = guiZimmer.launchSecond();	
				guiZimmer.labelVor3_2.setText(guiZimmer.jtfVorname2.getText());
				guiZimmer.labelName3_2.setText(guiZimmer.jtfName2.getText());
				guiZimmer.labelStr3_2.setText(guiZimmer.jtfStr2.getText() + " " + guiZimmer.jtfHn2.getText());
				guiZimmer.labelPlz3_2.setText(guiZimmer.jtfPlz2.getText());
				guiZimmer.labelOrt3_2.setText(guiZimmer.jtfOrt2.getText());
				guiZimmer.labelLand3_2.setText(guiZimmer.jtfLand2.getText());
								
				String Vorwahl = guiZimmer.jtfTel2_2.getText();
				
				if (Vorwahl.charAt(0) == '0'){
						
					String[] splitResult = Vorwahl.split("0", 2);
					Vorwahl = splitResult[1];
				}
							
				guiZimmer.labelTel3_2.setText(guiZimmer.jtfTel2_1.getText() + " (0) "+ Vorwahl + " " + guiZimmer.jtfTel2_3.getText());
											
				SimpleDateFormat geb2 =new SimpleDateFormat("dd.MM.yyyy");
				String geb = geb2.format(guiZimmer.geb2.getDate());
				guiZimmer.labelGeb3_2.setText(geb);
							
				guiZimmer.card.add("Card2", guiZimmer.contentpane3);
				guiZimmer.cardLayout.show(this.guiZimmer.card, "Card2");
			}
			
			/*catch (GUIException gex){
			
					JOptionPane.showMessageDialog(null, gex, "Error",
				                                  JOptionPane.ERROR_MESSAGE);
			}
			*/
			catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(guiZimmer.jf, "Bitte Geburtsdatum eintragen", "Error",
						JOptionPane.ERROR_MESSAGE);
			}	
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
				checkBookingDate(guiZimmer.pickerVon.getDate(), guiZimmer.pickerBis.getDate());
				int answer = JOptionPane.showConfirmDialog(guiZimmer.jf, "Zimmer wirklich buchen?", "Error",JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.out.println("YES");	
					guiZimmer.jf.dispose();
				}
			
			}
			catch (GUIException gex) {
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			}			
			catch (NullPointerException nex) {
				JOptionPane.showMessageDialog(null, "Bitte Buchungsdatum eintragen", "Error",
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
	

