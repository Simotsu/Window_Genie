package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import GUIs.invoiceGUI;


public class connectToDB {	
	Connection myConn;
	public Connection getConnected() throws SQLException{
				myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/window_genie", "root", "root");
				System.out.println("Connected");
		 return myConn;
		}
	
	public void closeConnection() throws SQLException {
		myConn.close();
	}
	}