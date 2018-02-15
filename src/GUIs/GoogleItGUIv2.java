package GUIs;


import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_F4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.Scene;
public class GoogleItGUIv2 extends Application{
	private GridPane gPane = new GridPane();
	private Button btGglIt = new Button("Google It!");
	private Button btBack = new Button("Back");
	private Label lbl1 = new Label("Enter a Phrase to Google: ");
	private Label lbl2 = new Label("Amount of times(Max: 999999): ");
	private Text lbl3 = new Text("");
	private TextField phrase = new TextField();
	private TextField amount = new TextField("5");
	private TextField x = new TextField("363");
	private TextField y = new TextField("252");
	private CheckBox activateClick = new CheckBox("Activate Left Click");
	
	public void start(Stage primaryStage) throws Exception {
		Altbot myAlt = new Altbot();
		Robot myRobot = new Robot();
		gPane.add(lbl1, 0,0);
		gPane.add(phrase, 1, 0);
		gPane.add(lbl2, 0, 1);
		gPane.add(amount, 1, 1);
		gPane.add(lbl3, 1, 2);
		gPane.add(activateClick, 0, 2);
		gPane.add(x, 0, 3);
		gPane.add(y, 1, 3);
		
		gPane.add(btBack, 0, 4);
		gPane.add(btGglIt, 1, 4);
		gPane.setHgap(5);
		gPane.setVgap(10);
		x.setMaxSize(50, 1);
		y.setMaxSize(50, 1);
		amount.setMaxSize(50,1);
		Scene scene = new Scene(gPane, 330, 170);
		
		
		
		primaryStage.setTitle("Google It Automation");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setWidth(350);
		primaryStage.setHeight(200);
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((primScreenBounds.getWidth() - primaryStage
				.getWidth()) / 2);
		primaryStage.setY((primScreenBounds.getHeight() - primaryStage
				.getHeight()) / 2);
        primaryStage.show();
	
	btGglIt.setOnAction(e -> {
		// create altBot, and Robot objects.
		// amount1 = Number entered into box indicating number of
		// times to search.
		final int amount1 = Integer.parseInt(amount.getText());
		// If someone enters 0 into amount1, infinite loop it.
		if (amount1 == 0) {
			// infinite loop condition here. if amount1 = 0; it will
			// never = 1.
			while (amount1 != 1) {
				try {
					OpenChrome.main(null);// open chrome
				} catch (InterruptedException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					justWait();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// newString = input by user to search for
				final String newString = phrase.getText();

				/*
				 go through the input 1 char at a time
				 passing in the char to type() method in Altbot
				 class.
				 This will type the phrase out one charecter at a
				 time into the search box for google.
				 */
				for (int x = 0; x < newString.length(); x++) {
					myAlt.type(newString.charAt(x));
				}
				// press and release enter
				myRobot.keyPress(VK_ENTER);
				myRobot.keyRelease(VK_ENTER);
				try {
					justWait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// if checkbox(Enable left Click is selected)
				// move mouse to x,y axis provided.
				// perform a left click at the location
				// (This is used to actually access and register
				// hits to your website)
				if (activateClick.isSelected() == true) {
					int xaxis = Integer.parseInt(x.getText());// get x input
					int yaxis = Integer.parseInt(y.getText());// get y input
					myRobot.mouseMove(xaxis, yaxis);// move mouse to x,y coords given 
					myRobot.delay(10);//wait
					myRobot.mousePress(InputEvent.BUTTON1_MASK);//left click press
					myRobot.mouseRelease(InputEvent.BUTTON1_MASK);// left click release
				}

				// This will exit chrome. using Alt+F4
				myRobot.keyPress(VK_ALT);//press alt
				myRobot.keyPress(VK_F4);//press f4
				myRobot.keyRelease(VK_ALT);//release alt
				myRobot.keyRelease(VK_F4);//release f4
			}
		}
		// else if you input a number into the field other than 0, run it a certain number of times
		else {
			for (int i = 1; i <= amount1; i++) {//run it the specified amount of times not infinite
				try {
					OpenChrome.main(null);
				} catch (InterruptedException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				final String newString = phrase.getText();
				for (int x = 0; x < newString.length(); x++) {
					myAlt.type(newString.charAt(x));
				}

				myRobot.keyPress(VK_ENTER);
				myRobot.keyRelease(VK_ENTER);
				try {
					justWait();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (activateClick.isSelected() == true) {
					int xaxis = Integer.parseInt(x.getText());
					int yaxis = Integer.parseInt(y.getText());
					myRobot.mouseMove(xaxis, yaxis);
					myRobot.delay(10);
					try {
						justWait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					myRobot.mousePress(InputEvent.BUTTON1_MASK);
					myRobot.delay(5);
					myRobot.mouseRelease(InputEvent.BUTTON1_MASK);
				}
				try {
					justWait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				myRobot.keyPress(VK_ALT);
				myRobot.keyPress(VK_F4);
				myRobot.keyRelease(VK_ALT);
				;
				myRobot.keyRelease(VK_F4);
			}
		}

	});
	//go back to main Gui
	btBack.setOnAction(e -> {
		mainGUI mgui = new mainGUI();
		try {
			mgui.start(primaryStage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	});
//display mouse's x and y coordinates
	scene.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			lbl3.setText("(" + arg0.getScreenX() + ".xVal | " + arg0.getScreenY() + ".yVal)");
		}
	});
}
//make a left click method
public void leftClick() throws AWTException {
	Robot bot = new Robot();
	bot.mousePress(InputEvent.BUTTON1_MASK);
	bot.delay(10);
	bot.mouseRelease(InputEvent.BUTTON1_MASK);
}
//make a wait method to sleep the 
public static void justWait() throws InterruptedException{
	Thread.sleep(2000);
}
}
