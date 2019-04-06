
package reminders.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author villa
 */
public class Reminder implements Serializable {
    private String desc;
    private Calendar alertTime;
    
    public Reminder(String _desc) {
        desc = _desc;
    }

    public Reminder(String _desc, Calendar _alertTime) {
        desc = _desc;
        alertTime = _alertTime;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public Calendar getAlertTime() {
        return alertTime;
    }
    
    
}
