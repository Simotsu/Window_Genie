package GUIs;
/*Justin James Thomas
 * 9:18am 9/18/2017
 * Window Genie2.0
 */
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class invoiceGUI extends Application{
	//Create Buttons tp use as  GUI Application
	Button btCreate = new Button("Create Invoice");
	Button btClear = new Button("Clear Fields");
	Button btBack = new Button("Back");
	
	TextField tfBusinessName = new TextField();
	String businessName = " ";

	@Override
	public void start(Stage primaryStage) throws Exception {
		//eventually would like to throw Vbox into a borderpane and setup graphics on top.
		//using lambda expressions I handle each button Event

		
		btCreate.setOnAction(e -> {
			try {
				businessName = tfBusinessName.getText();
				createInvoiceGUI cIG = new createInvoiceGUI();
				cIG.runInvoice(businessName);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		btClear.setOnAction(e -> {
			try {
				//input shit here
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		btBack.setOnAction(e -> {
			try {
				mainGUI mg = new mainGUI();
				mg.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		

		//set the stage and the scene
		Scene scene = new Scene(getBPane(), 500, 500);
		primaryStage.setTitle("Window Genie v2.0");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setWidth(315);
		primaryStage.setHeight(120);
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((primScreenBounds.getWidth() - primaryStage
				.getWidth()) / 2);
		primaryStage.setY((primScreenBounds.getHeight() - primaryStage
				.getHeight()) / 2);
        primaryStage.show();
	}
	
	public BorderPane getBPane() {
		BorderPane bPane = new BorderPane();
		bPane.setCenter(getGpane());
		bPane.setBottom(getHBox());
		bPane.setTop(null);
		return bPane;
	}
	
	public GridPane getGpane() {
		GridPane gPane = new GridPane();
		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.add(new Label("Business Name : "), 0, 1);
		gPane.add(tfBusinessName, 1, 1);
		return gPane;
	}
	
	public HBox getHBox() {
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btCreate, btClear, btBack);
		return pane;
	}
	public String getTextField() {
		return tfBusinessName.getText();
	}
}
