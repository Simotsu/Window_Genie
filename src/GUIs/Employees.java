package GUIs;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Database.Employee;
import Database.resCustomer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Employees extends Application{
	//Create Buttons
	private Button btUpdate = new Button("Update Employee");
	private Button btBack = new Button("Back");
	//Create Text Fields for Input
	private TextField tfFirstName = new TextField();
	private TextField tfLastName = new TextField();
	private TextField tfBusinessName = new TextField();
	private TextField tfCell = new TextField();
	private TextField tfSecondaryNum = new TextField();
	private TextField tfEmail = new TextField();
	private TextField tfAddress = new TextField();
	private TextField tfCity = new TextField();
	private TextField tfSalary = new TextField();
	private TextField tfPosition = new TextField();

	//create radiobuttons to switch between accounts
	ObservableList<Employee> data = FXCollections.observableArrayList();
	//create a tableview to hold the database information that we would like to display
	TableView<Employee> table = new TableView<Employee>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//eventually would like to throw Vbox into a borderpane and setup graphics on top.
		BorderPane bPane = new BorderPane();
		HBox pane = new HBox(10);
		pane.setPrefSize(20, 20);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(btUpdate, btBack);
		bPane.setBottom(pane);
		bPane.setCenter(getGridPane());
		bPane.setTop(getTable());
		
		btBack.setOnAction(e -> {
			mainGUI mgui = new mainGUI();
			try {
				mgui.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	


		//When you hit input will insert the info into the database
		btUpdate.setOnAction(e -> {
			try {
				//1 Get connection
				Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/window_genie", "root", "root");
				System.out.println("Connected");
				
				//2Execute SQL Query
				String query = "INSERT INTO employees (res_first_name, res_last_name, res_cell_num, res_secondary_phone, res_email, res_address, res_city, res_window_count, res_price, res_misc_info)" + 
																"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement prepState = (PreparedStatement) myConn.prepareStatement(query);
				prepState.setString(1, tfFirstName.getText());
				prepState.setString(2, tfLastName.getText());
				prepState.setString(3, tfCell.getText());
				prepState.setString(4, tfSecondaryNum.getText());
				prepState.setString(5, tfEmail.getText());
				prepState.setString(6, tfAddress.getText());
				prepState.setString(7, tfCity.getText());
				prepState.setString(8, tfSalary.getText());
				prepState.setString(9, tfPosition.getText());
				//4 Process results
				prepState.execute();
				System.out.println("Insert into Residential Customer Complete");
				myConn.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			});
		
		
		
		Scene scene = new Scene(bPane, 300, 700);
		primaryStage.setTitle("Customer Input");
		primaryStage.setScene(scene);
		primaryStage.setWidth(315);
		primaryStage.setHeight(570);
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((primScreenBounds.getWidth() - primaryStage
				.getWidth()) / 2);
		primaryStage.setY((primScreenBounds.getHeight() - primaryStage
				.getHeight()) / 2);
        primaryStage.show();
		primaryStage.show();
	}
	
	//Set Up GridPane for inputs (Easy to edit)
	private GridPane getGridPane() {
		GridPane gPane = new GridPane();
		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.add(new Label("First Name : "), 0, 1);
		gPane.add(tfFirstName, 1, 1);
		gPane.add(new Label("Last Name : "), 0, 2);
		gPane.add(tfLastName, 1, 2);
		gPane.add(new Label("Business Name : "), 0, 3);
		gPane.add(tfBusinessName, 1, 3);
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
		gPane.add(new Label("Salary : "), 0, 9);
		gPane.add(tfSalary, 1, 9);
		gPane.add(new Label("Position : "), 0, 10);
		gPane.add(tfPosition, 1, 10);
		return gPane;
	}
	public ObservableList<Employee> getData(){
		 try {
				//1 Get connection
				Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/window_genie", "root", "root");
				System.out.println("Connected");
				//2Create a statement
				Statement myStmt = myConn.createStatement();
				//Statement myStmt = newConn.getConnected().createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from employees");
				while (myRs.next()) {
					//add to observable array list
					 data.add(new Employee(myRs.getString("em_first_name"),
							 myRs.getString("em_last_name"), 
							 myRs.getString("em_cell_num"),
							 myRs.getString("em_secondary_num"),
							 myRs.getString("em_email"),
							 myRs.getString("em_address"),
							 myRs.getString("em_city"),
							 myRs.getString("em_salary"),
							 myRs.getString("em_position")));
				}
				//newConn.closeConnection();
				myConn.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}  
		    return data;
		}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableView<Employee> getTable(){
		 
        table.setEditable(true);
   	 
		TableColumn nameCol = new TableColumn("First Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("fName"));
        
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("lName"));
        
        TableColumn cellCol = new TableColumn("Cell Number");
        cellCol.setMinWidth(110);
        cellCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("cellNum"));
        
        TableColumn secondaryNumCol = new TableColumn("Secondary Number");
        secondaryNumCol.setMinWidth(100);
        secondaryNumCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("SecNum"));
        
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(120);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("email"));
        
        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(150);
        addressCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("address"));
        
        TableColumn cityCol = new TableColumn("City");
        cityCol.setMinWidth(80);
        cityCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("City"));
        
        TableColumn salaryCol = new TableColumn("Salary");
        salaryCol.setMinWidth(50);
        salaryCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("salary"));
        
        TableColumn positionCol = new TableColumn("Position");
        positionCol.setMinWidth(200);
        positionCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("position"));

        table.setItems(getData());
        table.getColumns().addAll(nameCol, lastNameCol, cellCol, secondaryNumCol, emailCol, addressCol, cityCol, salaryCol, positionCol);
 
		return table;
	}
	
}
