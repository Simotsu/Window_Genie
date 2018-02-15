package Database;

import java.sql.ResultSet;
import java.sql.Statement;
import Database.resCustomer;
import GUIs.mainGUI;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

	public class resAccntView extends Application {

		//create Buttons
		private Button btSearch = new Button("Search");
		private Button btBack = new Button("Back");
		private Button btClearTable = new Button("Clear Table");
		private Button btClear = new Button("Clear Search Entries");
		//checkout toolbar**************
		//ToolBar tBar = new ToolBar();
		//create textFields
		private TextField tfFirstName = new TextField("");
		private TextField tfLastName = new TextField("");
		private TextField tfWindowCount = new TextField("");
		private TextField tfCell = new TextField("");
		private TextField tfSecondaryNum = new TextField("");
		private TextField tfEmail = new TextField("");
		private TextField tfAddress = new TextField("");
		private TextField tfCity = new TextField("");
		private TextField tfPrice = new TextField("");
		private String[] arr1 = new String[9];
		connectToDB newConn = new connectToDB();
		//create observable array list based off our Customer Class model
    	ObservableList<resCustomer> data = FXCollections.observableArrayList();
    	//create a tableview to hold the database information that we would like to display
    	TableView<resCustomer> table = new TableView<resCustomer>();

	 
	    @SuppressWarnings("static-access")
		@Override
		//start allows further manipulation later by calling a instatiating an object of a class then using its .start method to act like
		//a GUI application opening and closing windows
	    public void start(Stage primaryStage) throws Exception {
	    	//everything being put into a borderpane makes it nice and easy to organize later on.
	        BorderPane bPane = new BorderPane();
	        bPane.setAlignment(getGPane(), Pos.CENTER);
	        bPane.setMargin(getGPane(), new Insets(12,12,12,12));
	        bPane.setCenter(getGPane());
	        bPane.setTop(getVBox());
	        primaryStage.setWidth(1178);
	        primaryStage.setHeight(900);
	        
	        
	        //using lambda expressions enable buttons to work properly
	        //back button pulls up mainGui screen
			btBack.setOnAction(e -> {
				mainGUI mgui = new mainGUI();
				try {
					mgui.start(primaryStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			
			//search button is quite cool and took a very long time to figure it out
			//first clear out the observable list to make sure it does not create doubles
			btSearch.setOnAction(e -> {
				try {
					data.clear();
					searchData();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			//clears table of all data
			btClearTable.setOnAction(e -> {
				try {
					data.clear();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			//clears out text boxes back to "IS NOT NULL"
			btClear.setOnAction(e -> {
				try {
					tfFirstName.setText("");
					tfLastName.setText("");
					tfWindowCount.setText("");
					tfCell.setText("");
					tfSecondaryNum.setText("");
					tfEmail.setText("");
					tfAddress.setText("");
					tfCity.setText("");
					tfPrice.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
	        
			//create scene
	        Scene scene = new Scene(new Group());
	        ((Group) scene.getRoot()).getChildren().addAll(bPane);
	        primaryStage.setTitle("Residential Accounts");
	        primaryStage.setScene(scene);
			primaryStage.setWidth(1150);
			primaryStage.setHeight(900);
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			primaryStage.setX((primScreenBounds.getWidth() - primaryStage
					.getWidth()) / 2);
			primaryStage.setY((primScreenBounds.getHeight() - primaryStage
					.getHeight()) / 2);
	        primaryStage.show();
	    }

	    //here i will try to implement a search tool (got it to work)
	    public ObservableList<resCustomer> searchData(){
	    //	connectToDB newConn = new connectToDB();
			 try {
					//2Create a statement using DB Connection
					Statement myStmt = newConn.getConnected().createStatement();
					
					arr1[0] = "IS NOT NULL";
					arr1[1] = "IS NOT NULL";
					arr1[2] = "IS NOT NULL";
					arr1[3] = "IS NOT NULL";
					arr1[4] = "IS NOT NULL";
					arr1[5] = "IS NOT NULL";
					arr1[6] = "IS NOT NULL";
					arr1[7] = "IS NOT NULL";
					arr1[8] = "IS NOT NULL";
					//get Result Set
					//the reason for the if statements here is because i want to be able to have the person not have to type in = '' for every search field
					if(tfFirstName.getText().equals("") == false) {
						arr1[0] = "= '" + tfFirstName.getText() + "'";
					}
					if(tfLastName.getText().equals("") == false) {
						arr1[1] = "= '" + tfLastName.getText() + "'";
					}
					if(tfCell.getText().equals("") == false) {
						arr1[2] = "= '" + tfCell.getText() + "'";
					}
					if(tfSecondaryNum.getText().equals("") == false) {
						arr1[3] = "= '" + tfSecondaryNum.getText() + "'";
					}
					if(tfEmail.getText().equals("") == false) {
						arr1[4] = "= '" + tfEmail.getText() + "'";
					}
					if(tfAddress.getText().equals("") == false) {
						arr1[5] = "= '" + tfAddress.getText() + "'";
					}
					if(tfCity.getText().equals("") == false) {
						arr1[6] = "= '" + tfCity.getText() + "'";
					}
					if(tfWindowCount.getText().equals("") == false) {
						arr1[7] = "= '" + tfWindowCount.getText() + "'";
					}
					if(tfPrice.getText().equals("") == false) {
						arr1[8] = "= '" + tfPrice.getText() + "'";
					}
						
					ResultSet myRs = myStmt.executeQuery("select * from residential_customer WHERE " + 
															"res_first_name " + arr1[0] +
															" AND res_last_name " + arr1[1] +
															" AND res_cell_num " + arr1[2] +
															" AND res_secondary_phone " + arr1[3] + 
															" AND res_email " + arr1[4] + 
															" AND res_address " + arr1[5] + 
															" AND res_city " + arr1[6] +  
															" AND res_window_count " + arr1[7] + 
															" AND res_price " + arr1[8]);
					while (myRs.next()) {
						//here I add the result set into the ObservableArrayList (data)while passing in the data to be added I call a new 
						//resCustomer. This is important to add it in this way so when retrieving the data you can get it out line by 
						//line with the getters
						 data.add(new resCustomer(myRs.getString("res_first_name"),
								 				myRs.getString("res_last_name"), 
								 				myRs.getString("res_cell_num"), 
								 				myRs.getString("res_secondary_phone"),
								 				myRs.getString("res_email"), 
								 				myRs.getString("res_address"), 
								 				myRs.getString("res_city"),
								 				myRs.getString("res_window_count"), 
								 				myRs.getString("res_price"),
								 				myRs.getString("res_misc_info")));
					}
					newConn.closeConnection();
					//myConn.close();
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}  
			 arr1[0] = "IS NOT NULL";
			 arr1[1] = "IS NOT NULL";
			 arr1[2] = "IS NOT NULL";
			 arr1[3] = "IS NOT NULL";
			 arr1[4] = "IS NOT NULL";
			 arr1[5] = "IS NOT NULL";
			 arr1[6] = "IS NOT NULL";
			 arr1[7] = "IS NOT NULL";
			 arr1[8] = "IS NOT NULL";
			    return data;
	    }
		
		public VBox getVBox() {
			final VBox vbox = new VBox();
	        final Label label = new Label("Residential Customers");
	        label.setFont(new Font("Arial", 20));
	        vbox.setSpacing(5);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        vbox.getChildren().addAll(label, getTable());
			return vbox;
			}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public TableView<resCustomer> getTable(){
		 
	        table.setEditable(true);
	   	 
			TableColumn nameCol = new TableColumn("First Name");
	        nameCol.setMinWidth(100);
	        nameCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("fName"));
	        
	        TableColumn lastNameCol = new TableColumn("Last Name");
	        lastNameCol.setMinWidth(100);
	        lastNameCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("lName"));
	        
	        TableColumn cellCol = new TableColumn("Cell Number");
	        cellCol.setMinWidth(110);
	        cellCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("cellNum"));
	        
	        TableColumn secondaryNumCol = new TableColumn("Secondary Number");
	        secondaryNumCol.setMinWidth(100);
	        secondaryNumCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("SecNum"));
	        
	        TableColumn emailCol = new TableColumn("Email");
	        emailCol.setMinWidth(120);
	        emailCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("email"));
	        
	        TableColumn addressCol = new TableColumn("Address");
	        addressCol.setMinWidth(150);
	        addressCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("address"));
	        
	        TableColumn cityCol = new TableColumn("City");
	        cityCol.setMinWidth(80);
	        cityCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("City"));
	        
	        TableColumn wndwCntCol = new TableColumn("Window Count");
	        wndwCntCol.setMinWidth(50);
	        wndwCntCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("resWndwCnt"));
	        
	        TableColumn priceCol = new TableColumn("Price");
	        priceCol.setMinWidth(50);
	        priceCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("price"));
	        
	        TableColumn miscCol = new TableColumn("Misc");
	        miscCol.setMinWidth(200);
	        miscCol.setCellValueFactory(
	                new PropertyValueFactory<resCustomer, String>("misc"));

	        table.setItems(searchData());
	        table.getColumns().addAll(nameCol, lastNameCol, cellCol, secondaryNumCol, emailCol, addressCol, cityCol, wndwCntCol, priceCol, miscCol);
	 
			return table;
		}
		
		
		public GridPane getGPane() {
			GridPane gPane = new GridPane();
			gPane.setHgap(10);
			gPane.setVgap(10);
			gPane.add(new Label("First Name : "), 0, 1);
			gPane.add(tfFirstName, 1, 1);
			gPane.add(new Label("Last Name : "), 0, 2);
			gPane.add(tfLastName, 1, 2);
			gPane.add(new Label("Window Count : "), 0, 3);
			gPane.add(tfWindowCount, 1, 3);
			gPane.add(new Label("Cell Number : "), 0, 4);
			gPane.add(tfCell, 1, 4);
			gPane.add(new Label("Secondary Number : "), 0, 5);
			gPane.add(tfSecondaryNum, 1, 5);
			gPane.add(new Label("Email : "), 0, 6);
			gPane.add(tfEmail, 1, 6);
			gPane.add(new Label("Address : "), 0, 7);
			gPane.add(tfAddress, 1, 7);
			gPane.add(new Label("City : "), 0, 8);
			gPane.add(tfCity, 1, 8);
			gPane.add(new Label("Price : "), 0, 10);
			gPane.add(tfPrice, 1, 10);
			gPane.add(btBack, 0, 13);
			gPane.add(btSearch, 1, 13);
			gPane.add(btClear, 0, 14);
			gPane.add(btClearTable, 1, 14);
			gPane.setAlignment(Pos.CENTER);
			return gPane;
		}

	} 