package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import GUI.*;

public class BHBookZimmer extends BHHelp implements ActionListener{
	
	BookZimmer gui;
	
	public BHBookZimmer(BookZimmer bookZimmer) {
		this.gui = bookZimmer;
	}
	
	public void actionPerformed(ActionEvent e) throws NullPointerException {
		
		System.out.println("Das Ereignis hat den Wert: " + e.getActionCommand());
		if (e.getActionCommand().equals("NewBooking")) {
			
			gui.launchJFrame();
			gui.cardLayout.show(this.gui.card, "Card1");
			
		}
		else if (e.getActionCommand().equals("NEXT")) {
			
			try {
				checkStringEmpty(gui.jtfVorname2.getText());
				checkStringEmpty(gui.jtfName2.getText());
				checkStringEmpty(gui.jtfStr2.getText());
				checkStringEmpty(gui.jtfHn2.getText());
				checkStringEmpty(gui.jtfPlz2.getText());
				checkStringEmpty(gui.jtfOrt2.getText());
				checkStringEmpty(gui.jtfTel2_1.getText());
				checkStringEmpty(gui.jtfTel2_2.getText());
				checkStringEmpty(gui.jtfTel2_3.getText());
				checkNumber(gui.jtfPlz2.getText());
				checkBirthday(gui.geb2.getDate());
				checkTel(gui.jtfTel2_2.getText(), gui.jtfTel2_3.getText());			
				
				gui.contentpane3 = gui.launchSecond();	
				gui.labelVor3_2.setText(gui.jtfVorname2.getText());
				gui.labelName3_2.setText(gui.jtfName2.getText());
				gui.labelStr3_2.setText(gui.jtfStr2.getText() + " " + gui.jtfHn2.getText());
				gui.labelPlz3_2.setText(gui.jtfPlz2.getText());
				gui.labelOrt3_2.setText(gui.jtfOrt2.getText());
							
								
				String Vorwahl = gui.jtfTel2_2.getText();
				
				if (Vorwahl.charAt(0) == '0'){
						
					String[] splitResult = Vorwahl.split("0", 2);
					Vorwahl = splitResult[1];
				}
							
				gui.labelTel3_2.setText(gui.jtfTel2_1.getText() + " (0) "+ Vorwahl + " " + gui.jtfTel2_3.getText());
								
								
				
							
				SimpleDateFormat geb2 =new SimpleDateFormat("dd.MM.yyyy");
				String geb = geb2.format(gui.geb2.getDate());
				gui.labelGeb3_2.setText(geb);
							
				gui.card.add("Card2", gui.contentpane3);
				gui.cardLayout.show(this.gui.card, "Card2");
					
		
			
			
			}
			
			catch (GUIException gex){
			
					JOptionPane.showMessageDialog(null, gex, "Error",
				                                  JOptionPane.ERROR_MESSAGE);
			}
			
						
					
		
	}
		else if (e.getActionCommand().equals("BACK")) 
			gui.cardLayout.show(gui.card, "Card1");
		
		else if (e.getActionCommand().equals("BOOK?")) {
			
			try {
				checkBookingDate(gui.pickerVon.getDate(), gui.pickerBis.getDate());
				int answer = JOptionPane.showConfirmDialog(gui.jf, "Zimmer wirklich buchen?", "Error",JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.out.println("YES");	
					gui.jf.dispose();
				}
			
			}
			catch (GUIException gex) {
				JOptionPane.showMessageDialog(null, gex, "Error",
                        JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			}			
		
	}	
}
	

