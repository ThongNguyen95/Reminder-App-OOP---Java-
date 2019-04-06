
package reminders.consoleview;

import consoleKit.MenuItem;
import java.util.Calendar;
import reminders.model.AllReminders;
import reminders.model.Reminder;
import reminders.model.ReminderList;

/**
 *
 * @author villa
 */
public final class TodaysReminders implements MenuItem {
    private final AllReminders all;

    // Get the list of reminders to work on
    public TodaysReminders(AllReminders _all) {
        all = _all;
    }

    // Display a list of today's reminders with their alert times, if present
    @Override
    public void execute() {
        for (Reminder rem: all.getTodays()) {
            System.out.print(rem.getDesc());
            Calendar alert = rem.getAlertTime();
            if (alert != null)
                //System.out.println(" " + alert.get(Calendar.HOUR) +
                //        ':' + alert.get(Calendar.MINUTE));
                System.out.println(String.format(" %1$tH:%1$tM", alert));
            else System.out.println();
        }
    }
    
    // Description of this command
    @Override
    public String toString() {
        return "List today’s reminders";
    }
}
