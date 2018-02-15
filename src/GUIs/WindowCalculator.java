package GUIs;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowCalculator extends Application {
		private TextField tfWindowNum = new TextField("Enter Number Of Windows");
		private TextField tfWindowPrice = new TextField("Enter Price Per Window");
		private TextField tfScreenNum = new TextField("Enter Number Of Screens");
		private TextField tfScreenPrice = new TextField("Enter Price Per Screen");
	public void start(Stage primaryStage) throws Exception {
		
		
		Scene scene = new Scene(getGPane(), 300, 700);
		primaryStage.setTitle("Customer Input");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private GridPane getGPane(){
		GridPane gPane = new GridPane();
		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.add(new Label("Number Of Windows : "), 0, 1);
		gPane.add(tfWindowNum, 1, 1);
		gPane.add(new Label("Price Per Window : "), 0, 2);
		gPane.add(tfWindowPrice, 1, 2);
		gPane.add(new Label("Number Of Screens : "), 0, 3);
		gPane.add(tfScreenNum, 1, 3);
		gPane.add(new Label("Price Per Screen : "), 0, 4);
		gPane.add(tfScreenPrice, 1, 4);
		return gPane;
	}
}
