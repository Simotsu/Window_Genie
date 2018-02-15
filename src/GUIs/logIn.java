package GUIs;
/*Justin James Thomas
 * 9:18am 9/18/2017
 * Window Genie2.0
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class logIn extends Application{
	//Create Buttons tp use as  GUI Application
	Button btCreate = new Button("Log In");
	Button btClear = new Button("Clear Fields");
	Button btBack = new Button("Cancel");
	
	TextField tfLogIn = new TextField();
	TextField tfPass = new TextField();
	String businessName = " ";

	@Override
	public void start(Stage primaryStage) throws Exception {
		//eventually would like to throw Vbox into a borderpane and setup graphics on top.
		//using lambda expressions I handle each button Event

	
		btClear.setOnAction(e -> {
			try {
				//input shit here
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		

		//set the stage and the scene
		Scene scene = new Scene(getBPane(), 500, 500);
		primaryStage.setTitle("Log-In to Database");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setWidth(315);
		primaryStage.setHeight(170);
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
		gPane.add(new Label("ID : "), 0, 1);
		gPane.add(tfLogIn, 1, 1);
		gPane.add(new Label("Password : "), 0, 2);
		gPane.add(tfPass, 1, 2);
		gPane.setAlignment(Pos.CENTER);
		return gPane;
	}
	
	public HBox getHBox() {
		HBox pane = new HBox(10);
		pane.getChildren().addAll(btCreate, btClear, btBack);
		pane.setAlignment(Pos.CENTER);
		return pane;
	}
	public String getTextField() {
		return"";
	}
}