package Control;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JFrame; 
import javax.swing.JOptionPane; 
import java.sql.*; 



public class WriteDB 
{
	public WriteDB(String SQLquery) 
	{ 
		try 
		{ 
			String sDbDriver=null, sDbUrl=null, sUsr="", sPwd=""; 
			// set access data for database connection 
			sDbDriver = "com.mysql.jdbc.Driver"; 
			// url of data base scheme (f.e. jdbc:mysql://localhost:3306/test) 
			sDbUrl = "jdbc:mysql://localhost:3306/Hotel"; 
			// user name (f.e. root) 
			sUsr = "root"; 
			// password (f.e. init) 
			sPwd = "init"; 
			// select fitting database driver and connect 
			Class.forName( sDbDriver ); 
			Connection cn = DriverManager.getConnection( sDbUrl, sUsr, sPwd ); 
			Statement st = cn.createStatement(); 
			// insert resp. delete entry 
			st.execute(SQLquery); 
			// to avoid side effects close connection 
			st.close(); 
			cn.close(); 
		} 
		catch (SQLException ex) 
		{ 
			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage()); 
		} 
		catch( ClassNotFoundException ex ) 
		{ 
			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage()); 
		} 
		
	}
}
