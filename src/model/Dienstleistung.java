package model;

import java.util.Date;

public class Dienstleistung extends ModelHelp {

	int did;
	Date date;
	String typ;
	int dnr;
	double preis;
	
	public Dienstleistung(int did, Date date) {
		this.did = did;
		this.date = date;
	}
	
	public Dienstleistung(int did, String typ, double preis)
	{
		this.did = did;
		this.typ = typ;
		this.preis = preis;
	}
	
	public Dienstleistung(int did,String typ,double preis,int dnr)
	{
		this.did = did;
		this.typ = typ;
		this.preis = preis;
		this.dnr = dnr;
	}


	public Dienstleistung(int did) {
		this.did = did;
	}
	
	public void createDienst()
	{
		writeDb("INSERT INTO dienstleistung (DID, Bezeichnung, Preis)" + "VALUES('" + did + "', '" + typ + "', '" + preis +"')");
	}
	public void updateDienst()
	{
		writeDb("update dienstleistung set DID = '" + did +"', Bezeichnung = '" + typ + "',  Preis = '" + preis + "' where DID = "+ dnr);
	}
	
	public void deleteDienst()
	{
		String query = "DELETE from " + "dienstleistung" + " WHERE " + 
				"DID" + " = '" + did + "'"; 
		writeDb(query); 
	}
	
	public int getDid(){
		return did;
	}
	
	public Date getDate(){
		return date;
	}
}
