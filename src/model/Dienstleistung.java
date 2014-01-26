package model;

import java.util.Date;

public class Dienstleistung {

	int did;
	Date date;
	
	public Dienstleistung(int did, Date date) {
		this.did = did;
		this.date = date;
	}
	
	public int getDid(){
		return did;
	}
	
	public Date getDate(){
		return date;
	}
}
