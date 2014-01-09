package Control;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BHHelp {

	public void checkNumber(String number) throws GUIException{
		
		try {
		Integer.parseInt(number);		
		}
		catch (NumberFormatException nex) {
			throw new GUIException("PLZ überprüfen");
		}
		
	}
	
	public void checkBirthday(Date geb) throws GUIException{
			Calendar cPast = new GregorianCalendar();
			Calendar cGeb = new GregorianCalendar();
			Calendar cNow = new GregorianCalendar();
			Date now = new Date();
			
			cPast.setTime(now);
			cPast.add(Calendar.YEAR, -120);
			cGeb.setTime(geb);
						
			if (cGeb.before(cPast) ) {
				throw new GUIException("Geburtsdatum überprüfen!");
			}	
			if (cGeb.after(cNow)) {
				throw new GUIException("Geburtsdatum überprüfen!");
			}
	}
	
	public void checkStringEmpty(String check) throws GUIException {
		
		if (check.equals(""))
			throw new GUIException("Bitte alle Felder ausführen!");
	}
	
	
	public void checkBookingDate(Date vonDate, Date bisDate) throws GUIException{
		
		Calendar cNow = new GregorianCalendar();
		Calendar cVonDate = new GregorianCalendar();
		Calendar cBisDate = new GregorianCalendar();
		cNow.setTime(new Date());
		cVonDate.setTime(vonDate);
		cBisDate.setTime(bisDate);
		
		if (cVonDate.before(cNow) || cBisDate.before(cNow)) {
			throw new GUIException("Buchungsdatum überprüfen!");
		}
		
		if(cVonDate.after(cBisDate))
			throw new GUIException("Buchungsdatum überprüfen!");
	
		
		
	}

	public void checkTel(String b, String c) throws GUIException{
		try {
		Integer.parseInt(b);
		Integer.parseInt(c);
		}
		catch (NumberFormatException ex) {
			throw new GUIException("Telefonnummer überprüfen!");
		}
		
	
		
	}
		
	
}
