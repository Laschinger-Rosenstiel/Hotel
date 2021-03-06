package control;

import java.sql.*; 
import javax.swing.JOptionPane; 
import javax.swing.JTable; 
import javax.swing.JFrame; 
import javax.swing.ListSelectionModel; 
import javax.swing.table.DefaultTableModel; 

public class JTableview extends JTable 
{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable SQLTable = null; 

	// 2. create JTable view based on a generic SQL query 
	public JTableview(String SQLquery) 
	{ 
		SQLTable = genSQLTable(SQLquery); 
	} 

	// update JTable view with new generic SQL query 
	public void updateTable(String SQLquery) 
	{ 
		SQLTable = genSQLTable(SQLquery); 
	}  
	// 4.1 return JTable view 
	public JTable getSQLTable() 
	{ 
		return SQLTable; 
	} 

	
	private JTable genSQLTable(String SQLquery) 
	{ 
		
		int columnCount = 0; 
		int cnt = 1; 
		
		JTable tableview = new JTable(); 
		tableview.enableInputMethods(false); 
		tableview.setDragEnabled(false); 
		tableview.setColumnSelectionAllowed(false); 
		
		tableview.setRowSelectionAllowed(true); 
		tableview.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
	
		//DefaultTableModel model = (DefaultTableModel) tableview.getModel();
		 DefaultTableModel model = new DefaultTableModel(){
	            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int i, int j){
	                return false;
	            }
	        };
		
		
		String sDbDriver=null, sDbUrl=null, sUsr="", sPwd=""; 
		
		sDbDriver = "com.mysql.jdbc.Driver"; 
		sDbUrl = "jdbc:mysql://localhost:3306/Hotel"; 
		sUsr = "root"; 
		sPwd = "init"; 

		try 
		{ 
			
			Class.forName( sDbDriver ); 
			Connection cn = DriverManager.getConnection( sDbUrl, sUsr, sPwd ); 
			Statement st = cn.createStatement(); 
			
			ResultSet rs = st.executeQuery(SQLquery); 

			
			ResultSetMetaData rsmd = rs.getMetaData(); 
			columnCount = rsmd.getColumnCount(); 

			
			for (int column = 1; column <= columnCount; column++) 
			{ 
				model.addColumn(rsmd.getColumnLabel(column)); 
			} 

			
			Object[] objects = new Object[columnCount]; 
			while (rs.next()) 
			{ 
				cnt = 0; 
				
				while(cnt < columnCount) 
				{ 
					objects[cnt] = rs.getObject(cnt+1); 
					cnt++; 
				} 
				model.addRow(objects); 
			} 
		} 

		catch( ClassNotFoundException ex ) 
		{ 
			System.out.println( ex.getMessage() ); 
		} 
		catch (SQLException e) 
		{ 
			JOptionPane.showMessageDialog(new JFrame(),e); 
		} 

		
		tableview.setModel(model);
		return tableview; 
	} 
	

} 


