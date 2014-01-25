package Model;

import java.util.Date;

public class Gast {

	private String Vorname;
	private String Name;
	private String Strasse;
	private String Hn;
	private String Plz;
	private String Ort;
	private String Land;
	private String Tel;
	private Date Geb;
	
	
	public Gast (String Vorname, String Name, String Strasse, String Hn, String Plz, String Ort, String Land, String Tel, Date Geb) {
		this.setVorname(Vorname);
		this.setName(Name);
		this.setStrasse(Strasse);
		this.setHn(Hn);
		this.setPlz(Plz);
		this.setOrt(Ort);
		this.setLand(Land);
		this.setTel(Tel);	
		this.setGeb(Geb);
	}
	
	public Gast (){
		
	}
	
	public String getVorname(){
		return this.Vorname;
	}
	
	public void setVorname(String vorname){
		this.Vorname = vorname;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getStrasse() {
		return Strasse;
	}

	public void setStrasse(String strasse) {
		Strasse = strasse;
	}

	public String getHn() {
		return Hn;
	}

	public void setHn(String hn) {
		Hn = hn;
	}

	public String getPlz() {
		return Plz;
	}

	public void setPlz(String plz) {
		Plz = plz;
	}

	public String getOrt() {
		return Ort;
	}

	public void setOrt(String ort) {
		Ort = ort;
	}

	public String getLand() {
		return Land;
	}

	public void setLand(String land) {
		Land = land;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public Date getGeb() {
		return Geb;
	}

	public void setGeb(Date geb) {
		Geb = geb;
	}

	
	
	
	
}
