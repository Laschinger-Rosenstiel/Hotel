package model;

public class Zimmer extends ModelHelper
{

	String zid;
	String typ;
	double preis;
	String znr;
	
	public Zimmer (String zid) {
		this.zid = zid;
	}
	public Zimmer(String zn, String typZ, double p)
	{
		zid = zn;
		typ = typZ;
		preis = p;
	}
	
	public Zimmer(String zn, String typZ, double p, String id)
	{
		zid = id;
		typ = typZ;
		preis = p;
		znr = zn;
	}
	
	public String getZid(){
		return zid;
	}
	
	public void changeZimmer()
	{
		writeDb("update zimmer set ZID = '" + znr +"',  Typ = '"+ typ +"', Preis = '"+ preis+"' where ZID = "+zid);
	}
	
	public void createZimmer()
	{
		writeDb("INSERT INTO zimmer (ZID, Typ, Preis)" + "VALUES('"+ zid + 
				"', '"+ typ+"', '"+ preis+"')");
	}
	
}
