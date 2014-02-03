package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ModelHelp {

	public String getSQLDate(Date date) {
		SimpleDateFormat Sql =new SimpleDateFormat("yyyy-MM-dd");
		return Sql.format(date);
	}

	public int writeDbAi(String SQLquery) {

		try {
			String sDbDriver=null, sDbUrl=null, sUsr="", sPwd=""; 
			sDbDriver = "com.mysql.jdbc.Driver"; 
			sDbUrl = "jdbc:mysql://localhost:3306/Hotel"; 
			sUsr = "root"; 
			sPwd = "init"; 
			Class.forName( sDbDriver ); 
			Connection cn = DriverManager.getConnection( sDbUrl, sUsr, sPwd ); 

			PreparedStatement stmt = cn.prepareStatement(SQLquery, 
					Statement.RETURN_GENERATED_KEYS);
			stmt.execute();
			ResultSet res = stmt.getGeneratedKeys();
			res.next();
			return res.getInt(1);
		}
		catch (SQLException ex) 
		{ 
			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage()); 
			return -1;
		} 
		catch( ClassNotFoundException ex ) 
		{ 
			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage()); 
			return -1;
		} 

	}

	public void writeDb(String SQLquery) 
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

	public String selectDB(String SQLquery) 
	{ 
		try 
		{ 
			String sDbDriver=null, sDbUrl=null, sUsr="", sPwd=""; 
			sDbDriver = "com.mysql.jdbc.Driver"; 
			sDbUrl = "jdbc:mysql://localhost:3306/Hotel"; 
			sUsr = "root"; 
			sPwd = "init"; 

			Class.forName( sDbDriver ); 
			Connection cn = DriverManager.getConnection( sDbUrl, sUsr, sPwd ); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery(SQLquery);
			rs.next();
			String result = rs.getString(1);

			st.close(); 
			cn.close(); 
			return result;
		} 
		catch (SQLException ex) 
		{ 
			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage()); 
			return "";
		} 
		catch( ClassNotFoundException ex ) 
		{ 
			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage());
			return "";
		} 

	}
}