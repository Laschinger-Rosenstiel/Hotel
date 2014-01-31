package model;

public class Zimmer extends ModelHelp
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
	
	public void updateZimmer()
	{
		writeDb("update zimmer set ZID = '" + znr +"',  Typ = '"+ typ +"', Preis = '"+ preis+"' where ZID = "+zid);
	}
	
	public void createZimmer()
	{
		writeDb("INSERT INTO zimmer (ZID, Typ, Preis)" + "VALUES('"+ zid + 
				"', '"+ typ+"', '"+ preis+"')");
	}
	
	public void deleteZimmer()
	{
		String query = "DELETE from " + "zimmer" + " WHERE " + 
				"ZID" + " = '" + zid + "'"; 
		writeDb(query);
	}
	
	public void setZnr(String x)
	{
		znr = x;
	}
	
	public String getZid(){
		return zid;
	}
	
}
