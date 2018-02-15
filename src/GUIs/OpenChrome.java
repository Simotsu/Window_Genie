package GUIs;

public class OpenChrome {
	public static void main(String args[]) throws InterruptedException { 
		try {	
			//try to open chrome from cmd line
		Runtime.getRuntime().exec((new String[]{"cmd", "/c","start chrome http://www.google.com"}));
		} 
		catch(Exception e) { 
			System.out.println(e.getMessage()); 
			} 
	       Thread.sleep(500);
		}
	
		}
	
