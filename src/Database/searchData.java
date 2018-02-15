package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import GUIs.invoiceGUI;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;

public class searchData {
	int counter = 0;
	String name;
	String name1[] = new String[6];
	invoiceGUI iGui = new invoiceGUI();
	connectToDB conn = new connectToDB();
	public String[] getData(String name){
		
		 try {
				//1 Get connection
			 	conn.getConnected();
				System.out.println("Search Level : " + name);
				//2Create a statement
				Statement myStmt = conn.getConnected().createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from commercial_customer WHERE com_business_name = '" + name + "'");
				while (myRs.next()) {
					//add to observable array list
							name1[0] = myRs.getString("com_business_name");
							name1[1] = myRs.getString("com_first_name") + " " + myRs.getString("com_last_name");
							name1[2] = myRs.getString("com_address");
							name1[3] = myRs.getString("com_city"); 
							name1[4] = myRs.getString("com_cell_num");
							name1[5] = myRs.getString("com_price");
				}
				conn.closeConnection();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}  
		 return name1;
		}
	}

