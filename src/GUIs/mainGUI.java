/*Window Genie
 * This application is my brainchild of many many years. I have always wanted to 
 * make my own software to help my company out and ease the use of work needed for any
 * particualar set of jobs. Especially Bookkeeping. This application is set to calculate taxes
 * Get EOY earnings as well as Monthly, and just overall track all aspects of computation.
 * Date Created: 1/18/2018
 * Edited: 
 * Creator: Justin Thomas
 * 
 */




package GUIs;
import Database.comAcctView;
import Database.resAccntView;
/*Justin James Thomas
 * 9:18am 9/18/2017
 * Window Genie2.0
 * This application will be used for window cleaners
 * 
 * 
 * 
 * 
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainGUI extends Application{
	//Images for Gui Buttons
	Image main = new Image("images/genie.jpg", 300, 300, false, false);
	ImageView mainImg = new ImageView(main);
	Image inputBt1 = new Image("images/input.jpg", 300, 500, true, false);
	ImageView inputBt = new ImageView(inputBt1);
	Image viewComBt1 = new Image("images/viewCom.jpg", 300, 500, true, false);
	ImageView viewComBt = new ImageView(viewComBt1);
	Image viewResBt1 = new Image("images/viewRes.jpg", 300, 500, true, false);
	ImageView viewResBt = new ImageView(viewResBt1);
	Image googlerBt1 = new Image("images/googler.jpg", 300, 500, true, false);
	ImageView googlerBt = new ImageView(googlerBt1);
	Image invoiceBt1 = new Image("images/invoice.jpg", 300, 500, true, false);
	ImageView invoiceBt = new ImageView(invoiceBt1);
	Image calcBt1 = new Image("images/Calc.jpg", 300, 500, true, false);
	ImageView calcBt = new ImageView(calcBt1);
	BackgroundImage myBI = new BackgroundImage(new Image("images/genie.jpg"), 
			BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	
	//Buttons made from Images
	Button btInput = new Button("", inputBt);
	Button btViewCom = new Button("", viewComBt);
	Button btViewRes = new Button("", viewResBt);
	Button btGoogler = new Button("", googlerBt);
	Button btInvoice = new Button("", invoiceBt);
	Button btCalc = new Button("", calcBt);
	Button btLogin = new Button("", calcBt);
	Button btEmployees = new Button("", calcBt);
	Button btTotal = new Button("", calcBt);
	Button btAbout = new Button("", calcBt);
	@Override
	public void start(Stage primaryStage) throws Exception {
		//eventually would like to throw Vbox into a borderpane and setup graphics on top.
		//using lambda expressions I handle each button Event

		//Lambda Button actions 
		btInput.setOnAction(e -> {
			inputCstGUI cstGUI = new inputCstGUI();
			try {
				cstGUI.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btCalc.setOnAction(e -> {
			windowCalc calcGUI = new windowCalc();
			try {
				calcGUI.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btGoogler.setOnAction(e -> {
			GoogleItGUIv2 googleGUI = new GoogleItGUIv2();
			try {
				googleGUI.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		btViewRes.setOnAction(e -> {
			resAccntView view = new resAccntView();
			try {
				view.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btViewCom.setOnAction(e -> {
		comAcctView viewCommGUI = new comAcctView();
			try {
		viewCommGUI.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btInvoice.setOnAction(e -> {
		invoiceGUI iG = new invoiceGUI();
			try {
		iG.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		//set the stage and the scene
		Scene scene = new Scene(getBPane());//create scene with BorderPane method
		primaryStage.setTitle("Window Genie v2.0");//set Title 
		primaryStage.setScene(scene);//set scene to stage
		primaryStage.show();//diplay stage
		primaryStage.setWidth(1000);//adjust width
		primaryStage.setHeight(840);//adjust height

		//The next 3 lines allow the GUI to be put at the center of the Screen everytime its opened.
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();//gets the screen size
		primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);//divides the size by 1/2(ie: gets the middle of the screens's X axis)
		primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);//divides the size by 1/2(ie: gets the middle of the screens Y axis)
	}
	
	public BorderPane getBPane() {
		BorderPane bPane = new BorderPane();
		bPane.setCenter(getGPane());
		//bPane.setAlignment(getGPane(), Pos.CENTER);
		bPane.setBackground(new Background(myBI));
		bPane.setPadding(new Insets(180, 5, 5, 180));
		return bPane;
	}
	
	public VBox getVBox() {
		VBox pane = new VBox(10);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(btInput, btViewCom, btViewRes, btGoogler, btInvoice, btCalc);
		return pane;
	}
	
	public GridPane getGPane() {
		GridPane gPane = new GridPane();
		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.add(btInput, 0, 0);
		gPane.add(btViewCom, 1, 0);
		gPane.add(btViewRes, 0, 1);
		gPane.add(btGoogler, 1, 1);
		gPane.add(btInvoice, 0, 2);
		gPane.add(btCalc, 1, 2);
		gPane.add(btLogin, 0, 3);
		gPane.add(btEmployees, 1, 3);
		gPane.add(btTotal, 0, 4);
		gPane.add(btAbout, 1, 4);
		return gPane;
	}
}
