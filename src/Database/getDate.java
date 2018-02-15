package Database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getDate {

	static Date date = new Date();
	public String getNewDate(){
		DateFormat dF = new SimpleDateFormat("MM");

		String monthString = "";
		switch (Integer.parseInt(dF.format(date))) {
        case 1:  monthString = "January";
                 break;
        case 2:  monthString = "February";
                 break;
        case 3:  monthString = "March";
                 break;
        case 4:  monthString = "April";
                 break;
        case 5:  monthString = "May";
                 break;
        case 6:  monthString = "June";
                 break;
        case 7:  monthString = "July";
                 break;
        case 8:  monthString = "August";
                 break;
        case 9:  monthString = "September";
                 break;
        case 10: monthString = "October";
                 break;
        case 11: monthString = "November";
                 break;
        case 12: monthString = "December";
                 break;
        default: monthString = "Invalid month";
                 break;
    }
    System.out.println(dF.format(date));
		return monthString;
	}
	//get the end of the next month
	public String getNextDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yy");//create the format (IE: "Jan 01 18" is this format)
	    Calendar c = Calendar.getInstance();//create a calander object 
	    c.setTime(date);//set the date to today
	    c.add(Calendar.MONTH, 1);//add one month to the caledar.
	    c.set(Calendar.DATE, c.getMaximum(Calendar.DATE));//get the last day of that month.
	    String nextDate = sdf.format(c.getTime());//creat a string to hold the new formatted date.
	    
	    return nextDate;//return the date as a string (Feb 01 18)
	}
}
