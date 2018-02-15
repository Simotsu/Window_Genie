/* ALT BOT is NOT MY CODE
 * This Class I found Online and used it to implement my GoogleItGUI
 * The website can be found here
 * https://stackoverflow.com/questions/1248510/convert-string-to-keyevents
 * Answer number 5 to the question contains the class the author is:
 * answered Oct 16 '13 at 1:22 by Ryan Hilbert
 */

package GUIs;

import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_NUMPAD0;
import java.awt.AWTException;
import java.awt.Robot;

public class Altbot extends Robot{
	//handles super constructor.
    public Altbot() throws AWTException{
    }
//altBot is pretty cool, it changes every charecter into its ASCII one by one.
    public void type(char c){//takes in one char parameter at a time
        keyPress(VK_ALT);//presses alt
        keyPress(VK_NUMPAD0);//presses 0
        keyRelease(VK_NUMPAD0);//release 0
        //changes every character into its altcode. so it can press every charecter input into the textbox.
        String altCode = Integer.toString(c);//tis returns the char ascii number as an interger and puts it into a string
        for(int i=0;i<altCode.length();i++){//for every number in alt code string
            c=(char)(altCode.charAt(i)+'0');//make c into the ascii number and add a zero. 
            delay(20);//wait 20ms
            keyPress(c);//press the numbers assigned to c
            delay(20);//wait 20ms
            keyRelease(c);//release the keys pressed
        }
        keyRelease(VK_ALT);//release alt, therefor inputting the ascii value
    }
}