package GUIs;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class inputCstGUI extends Application{
	//Create Buttons
	private Button btInputCst = new Button("Input Customer");
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
	private TextField tfWindowCount = new TextField("Not Applicable");
	private TextField tfPrice = new TextField();
	private TextArea tfMiscInfo = new TextArea();
	//create radiobuttons to switch between accounts
	private RadioButton rbComm = new RadioButton("Commercial Account");
	private RadioButton rbResi = new RadioButton("Residential Account");
	
	ToggleGroup tg1 = new ToggleGroup();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//eventually would like to throw Vbox into a borderpane and setup graphics on top.
		BorderPane bPane = new BorderPane();
		HBox pane = new HBox(10);
		tfMiscInfo.setPrefColumnCount(3);
		tfMiscInfo.setPrefRowCount(5);
		pane.setPrefSize(20, 20);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(btInputCst, btBack);
		bPane.setBottom(pane);
		bPane.setCenter(getGridPane());
		
		btBack.setOnAction(e -> {
			mainGUI mgui = new mainGUI();
			try {
				mgui.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		rbResi.setOnAction(e ->{
			if (rbResi.isSelected()) {
				tfWindowCount.setText(" ");
				tfBusinessName.setText("Not Applicable");
			}
		});
		rbComm.setOnAction(e -> {
		if (rbComm.isSelected()) {
			tfBusinessName.setText(" ");
			tfWindowCount.setText("Not Applicable");
		}
	});

		rbComm.setSelected(true);
		rbComm.setToggleGroup(tg1);
		rbResi.setToggleGroup(tg1);


		//When you hit input will insert the info into the database
		btInputCst.setOnAction(e -> {
			if (rbResi.isSelected()) {
			try {
				//1 Get connection
				Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/window_genie", "root", "root");
				System.out.println("Connected");
				
				//2Execute SQL Query
				String query = "INSERT INTO residential_customer (res_first_name, res_last_name, res_cell_num, res_secondary_phone, res_email, res_address, res_city, res_window_count, res_price, res_misc_info)" + 
																"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement prepState = (PreparedStatement) myConn.prepareStatement(query);
				prepState.setString(1, tfFirstName.getText());
				prepState.setString(2, tfLastName.getText());
				prepState.setString(3, tfCell.getText());
				prepState.setString(4, tfSecondaryNum.getText());
				prepState.setString(5, tfEmail.getText());
				prepState.setString(6, tfAddress.getText());
				prepState.setString(7, tfCity.getText());
				prepState.setString(8, tfWindowCount.getText());
				prepState.setString(9, tfPrice.getText());
				prepState.setString(10, tfMiscInfo.getText());
				//4 Process results
				prepState.execute();
				System.out.println("Insert into Residential Customer Complete");
				myConn.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}}
			//if commercial account use commercial database
			else if(rbComm.isSelected()) {
				try {
					//1 Get connection
					Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/window_genie", "root", "root");
					System.out.println("Connected");
					//2Create a statement
					Statement myStmt = myConn.createStatement();
					
					//3Execute SQL Query
					String query = "INSERT INTO commercial_customer (com_first_name, com_last_name, com_business_name, com_cell_num, com_secondary_phone, com_email, com_address, com_price, com_misc_info)" + 
																	"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement prepState = (PreparedStatement) myConn.prepareStatement(query);
					prepState.setString(1, tfFirstName.getText());
					prepState.setString(2, tfLastName.getText());
					prepState.setString(3, tfBusinessName.getText());
					prepState.setString(4, tfCell.getText());
					prepState.setString(5, tfSecondaryNum.getText());
					prepState.setString(6, tfEmail.getText());
					prepState.setString(7, tfAddress.getText());
					prepState.setString(8, tfPrice.getText());
					prepState.setString(9, tfMiscInfo.getText());
					//4 Process results
					prepState.execute();
					System.out.println("Insert into Commercial Customer Complete");
					myConn.close();
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}}
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
		gPane.add(new Label("Window Count : "), 0, 9);
		gPane.add(tfWindowCount, 1, 9);
		gPane.add(new Label("Price : "), 0, 10);
		gPane.add(tfPrice, 1, 10);
		gPane.add(new Label("Misc. Information : "), 0, 11);
		gPane.add(tfMiscInfo, 1, 11);
		gPane.add(rbComm, 0, 13);
		gPane.add(rbResi, 1, 13);
		return gPane;
	}
}
