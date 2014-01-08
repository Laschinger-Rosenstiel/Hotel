package Control;

public class Help {
	
	public String vorname, name, strasse, hausn, plz, ort, geb, tel;
	
	public String getTf(String tf) {
		if (tf == "name") 
			return name;
		if (tf == "vorn")
			return vorname;
		if(tf == "strasse")
			return strasse;
		if (tf == "hausn")
			return hausn;
		if (tf == "plz")
			return plz;
		if (tf == "ort")
			return ort;
		if (tf == "geb")
			return geb;
		if (tf == tel)
			return tel;
		
		return "";
	}
}
