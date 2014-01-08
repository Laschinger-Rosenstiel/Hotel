package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.*;

public class BHBookZimmer implements ActionListener{
	
	BookZimmer gui;
	
	public BHBookZimmer(BookZimmer bookZimmer) {
		this.gui = bookZimmer;
	}
	
	public void actionPerformed(ActionEvent e) throws NullPointerException {
		
		System.out.println("Das Ereignis hat den Wert: " + e.getActionCommand());
		if (e.getActionCommand().equals("NewBooking")) {
			
			this.gui.launchSecondJFrame();
			this.gui.cardLayout.show(this.gui.card, "Card1");
			
		}
		else if (e.getActionCommand().equals("NEXT")) {
			
			if (this.gui.jtfVorname2.getText().equalsIgnoreCase("") | this.gui.jtfName2.getText().equalsIgnoreCase("")|
					this.gui.jtfStr2.getText().equalsIgnoreCase("") | this.gui.jtfHn2.getText().equalsIgnoreCase("") |
					this.gui.jtfPlz2.getText().equalsIgnoreCase("") | this.gui.jtfOrt2.getText().equalsIgnoreCase(""))
				//	this.gui.jtfTel2.get  Text().equalsIgnoreCase(""))			
	// Abfrage ob korrekte Telefonnumer und korrekte PLZ fehlt noch
			
				{	
					JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfüllen!", "Error",
				                                  JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (checkBirthday(this.gui.geb2.getDate()) && checkNumber(this.gui.jtfPlz2.getText()) /*&& 
						checkNumber(this.gui.jtfTel2.getText())*/) {
						
						gui.contentpane3 = gui.launchThirdJFrame();
						
						this.gui.labelVor3_2.setText(this.gui.jtfVorname2.getText());
						this.gui.labelName3_2.setText(this.gui.jtfName2.getText());
						this.gui.labelStr3_2.setText(this.gui.jtfStr2.getText() + " " + this.gui.jtfHn2.getText());
						this.gui.labelPlz3_2.setText(this.gui.jtfPlz2.getText());
						this.gui.labelOrt3_2.setText(this.gui.jtfOrt2.getText());
					//	this.gui.labelTel3_2.setText(this.gui.jtfTel2.getText());
					//	this.gui.labelTel3_2.setText(this.gui.jtfTel2_1.getText().replaceAll("[^0-9\\+]|((?<!\\A)\\+)", ""));
					
						if(this.gui.jtfTel2_2.getText().charAt(0)== '0') {
							String tel = this.gui.jtfTel2_2.getText();
							String[] splitResult = tel.split("0", 2); // –> splitten an den Leerzeichen
							System.out.println(splitResult[0]);
							this.gui.labelTel3_2.setText(this.gui.jtfTel2_1.getText()+" (0) "+splitResult[1]+" "+ 
									this.gui.jtfTel2_3.getText());
						}
						else {
							
							this.gui.labelTel3_2.setText(this.gui.jtfTel2_1.getText()+" (0) "+this.gui.jtfTel2_2.getText()+ " " + this.gui.jtfTel2_3.getText());
						}
						
						SimpleDateFormat geb2 =new SimpleDateFormat("dd.MM.yyyy");
						String geb = geb2.format(this.gui.geb2.getDate());
						this.gui.labelGeb3_2.setText(geb);
						
						this.gui.card.add("Card2", gui.contentpane3);
						this.gui.cardLayout.show(this.gui.card, "Card2");
					}	
				}
		}
		else if (e.getActionCommand().equals("BACK")) {
			this.gui.cardLayout.show(this.gui.card, "Card1");
		}
		else if (e.getActionCommand().equals("BOOK?")) {
			
			if (checkBookingDate(this.gui.pickerVon.getDate(), this.gui.pickerBis.getDate())){
				int answer = JOptionPane.showConfirmDialog(this.gui.jf2, "Zimmer wirklich buchen?", "Error",JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.out.println("YES");	
					this.gui.jf2.dispose();
				}
			}
			
			
		}
	}
	
	public boolean checkNumber(String number) throws NullPointerException{
		
		try {
		Integer.parseInt(number);
		}
		catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Ungültige Zahleneingabe", "Error",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
		
	}
	
	public boolean checkBirthday(Date geb) {
		try {
			boolean ret = false;
			Calendar cPast = new GregorianCalendar();
			Calendar cGeb = new GregorianCalendar();
			Calendar cNow = new GregorianCalendar();
			Date now = new Date();
			
			cPast.setTime(now);
			cPast.add(Calendar.YEAR, -120);
			cGeb.setTime(geb);
						
			if (cGeb.before(cPast) ) {
				throw new Exception();
			}	
			if (cGeb.after(cNow)) {
				throw new Exception();
			}
			ret = true;
			return ret;
			}
			catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Ungültiges Datumsformat", "Error",
                JOptionPane.ERROR_MESSAGE);
				return false;
			}
	}
	
	public boolean checkBookingDate(Date vonDate, Date bisDate){
		try {
		boolean ret = false;
		Calendar cNow = new GregorianCalendar();
		Calendar cVonDate = new GregorianCalendar();
		Calendar cBisDate = new GregorianCalendar();
		cNow.setTime(new Date());
		cVonDate.setTime(vonDate);
		cBisDate.setTime(bisDate);
		
		if (cVonDate.before(cNow) || cBisDate.before(cNow)) {
			throw new NullPointerException();
		}
		
		if(cVonDate.after(cBisDate))
			throw new Exception();
		
		ret = true;
		return ret;
		}
		catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Ungültiges Datum!", "Error",
	                JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}

