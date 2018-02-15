package GUIs;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import Database.connectToDB;
import Database.getDate;
import Database.searchData;


public class createInvoiceGUI {
static String[] writeOut;
static double tax;
static double total;
public void runInvoice(String business) throws IOException, InterruptedException, AWTException {
	Runtime.getRuntime().exec((new String[]{"cmd", "/c","start winword"}));//open word
	Robot r= new Robot();//instatiate a robot
	Thread.sleep(2000);
	r.keyPress(KeyEvent.VK_ENTER);//enter creates a blank doc
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_ENTER);//release enter
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_F10);//press f10 to highlight menu
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_F10);//release f10
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_F);//press f to open file menu
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_F);//release f
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_O);//press o to open a file
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_O);//release o
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_O);//press o agaain to browse your files
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_O);//release o
	Thread.sleep(100);
	callDoc();//type into the search filed for blankinvoice.docx and open it
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_ENTER);//open the doc
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_ENTER);//release enter
	Thread.sleep(100);
	String business1 = " ";//get the business name and put it into a string
	business1 = business;//here ^
	searchData sData = new searchData();//instatiate searchData, this will retrieve just the pertinent information
	connectToDB cDB = new connectToDB();//cant get this working yet
	writeOut = sData.getData(business1);//WriteOut will hold each value into an array one value at a time
	Thread.sleep(1000);
	Thread.sleep(100);
	r.mouseMove(821,420);//moves mouse to open position on document to start writing
	Thread.sleep(100);
	r.mousePress(InputEvent.BUTTON1_MASK);//left clicks to put cursor inside
	Thread.sleep(100);
	r.mouseRelease(InputEvent.BUTTON1_MASK);//release left click
	Thread.sleep(300);
	Altbot aBot = new Altbot();//call altBot to write it out for me
	for (int x = 0; x < writeOut[0].length(); x++) {
		aBot.type(writeOut[0].charAt(x));
	}
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_ENTER);//navigate the doc putting the information into the correct fields
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[1].length(); x++) {
		aBot.type(writeOut[1].charAt(x));
	}
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[2].length(); x++) {
		aBot.type(writeOut[2].charAt(x));
	}
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[3].length(); x++) {
		aBot.type(writeOut[3].charAt(x));
	}
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[4].length(); x++) {
		aBot.type(writeOut[4].charAt(x));
	}
	Thread.sleep(100);
	r.mouseMove(1038, 625);
	r.delay(10);
	//creating the date by clicking the button
	r.mousePress(InputEvent.BUTTON1_MASK);
	r.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[5].length(); x++) {
		aBot.type(writeOut[5].charAt(x));
	}
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_RIGHT);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_RIGHT);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[5].length(); x++) {
		aBot.type(writeOut[5].charAt(x));
	}
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[5].length(); x++) {
		aBot.type(writeOut[5].charAt(x));
	}
	//calculating the state tax for New Jersey
	tax = Double.parseDouble(writeOut[5]) * 0.0685;
	System.out.println(tax);
	total = Double.parseDouble(writeOut[5]) * 1.0685;
	writeOut[0] = String.format("%.2f", tax);
	writeOut[1] = String.format("%.2f", total);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[0].length(); x++) {
		aBot.type(writeOut[0].charAt(x));
	}
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	for (int x = 0; x < writeOut[1].length(); x++) {
		aBot.type(writeOut[1].charAt(x));
	}
	//here it does 2nd date
	Thread.sleep(100);
	r.mouseMove(765, 288);
	r.delay(10);
	r.mousePress(InputEvent.BUTTON1_MASK);
	r.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(200);
	r.mousePress(InputEvent.BUTTON1_MASK);
	r.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_T);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_T);
	Thread.sleep(100);
	r.mouseMove(1007, 530);
	r.delay(10);
	//3rd date here
	r.mousePress(InputEvent.BUTTON1_MASK);
	r.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(200);
	r.mousePress(InputEvent.BUTTON1_MASK);
	r.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(100);
//put the due date next month at the end of te month
	getDate gD = new getDate();//create a new object of getDate
	for (int x = 0; x < gD.getNextDate().length(); x++) {//create the getNext date.
		aBot.type(gD.getNextDate().charAt(x));//print out the date one char at a time
	}
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_F10);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_F);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_P);	
}
//name of the invoice doc here (this gets typed out)
public static void callDoc() throws AWTException, InterruptedException {
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_B);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_B);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_L);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_L);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_A);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_A);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_N);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_N);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_K);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_K);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_I);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_I);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_N);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_N);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_V);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_V);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_O);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_O);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_I);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_I);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_C);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_C);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_E);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_E);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_PERIOD);
	Thread.sleep(100);
	r.keyRelease(KeyEvent.VK_PERIOD);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_D);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_O);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_C);
	Thread.sleep(100);
	r.keyPress(KeyEvent.VK_X);
	Thread.sleep(100);
}
}
