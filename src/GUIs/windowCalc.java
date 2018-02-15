package GUIs;

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
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class windowCalc extends Application{
	//Buttons for calculator
	Button btCalc = new Button("Calculate");
	Button btClear = new Button("Clear");
	Button btBack = new Button("Back");
	
	TextField tfWindowCnt = new TextField();
	TextField tfPPW = new TextField();
	TextField tfScreenCnt = new TextField();
	TextField tfPPS = new TextField();
	TextField tfAnswer = new TextField();
	
	float WndwCnt, PPW, ScrnCnt, PPS;

	
	
	public void start(Stage primaryStage) throws Exception{
		
		tfAnswer.setEditable(false);
		btCalc.setOnAction(e -> {
			try {
				tfAnswer.setText("Total for windows and screens: " + (Float.parseFloat(tfWindowCnt.getText()) * Float.parseFloat(tfPPW.getText()) + 
						Float.parseFloat(tfScreenCnt.getText()) * Float.parseFloat(tfPPS.getText())));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btBack.setOnAction(e -> {
			mainGUI mgui = new mainGUI();
			try {
				mgui.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btClear.setOnAction(e -> {
			try {
				tfWindowCnt.clear();	
				tfPPW.clear();
				tfScreenCnt.clear();
				tfPPS.clear();
				tfAnswer.clear();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Scene scene = new Scene(getBPane(), 300, 300);
		primaryStage.setTitle("Window Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setWidth(615);
		primaryStage.setHeight(180);
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((primScreenBounds.getWidth() - primaryStage
				.getWidth()) / 2);
		primaryStage.setY((primScreenBounds.getHeight() - primaryStage
				.getHeight()) / 2);
		
	}
	public BorderPane getBPane() {
		BorderPane bPane = new BorderPane();
		bPane.setTop(getGPane());
		bPane.setCenter(getHBox());
		bPane.setBottom(getVBox());
		return bPane;
	}
	public GridPane getGPane() {
		GridPane gPane = new GridPane();
		gPane.add(new Label("Window Count : "), 0, 0);
		gPane.add(tfWindowCnt, 0, 1);
		gPane.add(new Label("Price Per Window : "), 1, 0);
		gPane.add(tfPPW, 1, 1);
		gPane.add(new Label("Screen Count : "), 2, 0);
		gPane.add(tfScreenCnt, 2, 1);
		gPane.add(new Label("Price Per Screen : "), 3, 0);
		gPane.add(tfPPS, 3, 1);
		return gPane;
	}
	
	public HBox getHBox() {
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btCalc, btClear, btBack);
		return hBox;
	}
	
	public VBox getVBox() {
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().add(tfAnswer);
		return vBox;
		
	}

	
}
