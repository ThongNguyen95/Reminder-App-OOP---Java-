package utils.dates;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * General date-related functions
 * @author villa
 */
public class Dates {
    // Get today's date
    public static Calendar getToday() {
        return new GregorianCalendar();
    }
    
    // Get today's year
    // Does create a Calendar object each time
    public static int getThisYear() {
        return getToday().get(Calendar.YEAR);
    }
}
