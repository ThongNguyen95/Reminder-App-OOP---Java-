package reminders.consoleview;

import consoleKit.Console;
import static consoleKit.Console.STDIN;
import consoleKit.IO;
import consoleKit.MenuItem;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import reminders.model.AllReminders;
import reminders.model.Reminder;
import reminders.model.ReminderList;
import utils.dates.Dates;

/**
 * Support adding a reminder through console input
 * @author villa
 */
public final class AddReminder implements MenuItem {
    // how many years in advance we can set a reminder alert
    private static final int MAX_ADVANCE = 100;
    private final ReminderList remList;
    private final AllReminders allrems;
    // The alert for the reminder
    private final Alert alarm;

    // get list to work with
    public AddReminder(ReminderList _remList, AllReminders _allrems) {
        remList = _remList;
        alarm = new Alert();
        allrems = _allrems;
    }

    // Get values and add a reminder to the list
    // TODO: The MenuItem interface should require this function
    @Override
    public void execute() {
        String desc;
        System.out.println("Enter the description of the reminder: ");
        // Looping because most Scanner methods only read up to, but not
        // including, the end of line
        do {
            desc = STDIN.nextLine();
        } while (desc.trim().equals(""));
        System.out.print("Do you want to set an alert for the reminder (y/n)? ");
        String setAlert = STDIN.next();
        if (setAlert.toLowerCase().equals("y")) {
            int yr, mo, day, hr, min;
            int thisyr = Dates.getThisYear();
            yr = Console.intInRange("Enter a year:", thisyr, thisyr+MAX_ADVANCE);
            // Add 1 in the parameters to have more natural numbers for the month
            // Then subtract 1 to keep the value stored consistent with
            // what the library code expects
            mo = Console.intInRange("Enter a month:", Calendar.JANUARY+1, Calendar.DECEMBER+1) - 1;
            day = Console.intInRange("Enter a day:", 1, 31);
            hr = Console.intInRange("Enter an hour:", 0, 23);
            min = Console.intInRange("Enter a minute:", 0, 59);
            GregorianCalendar alert = new GregorianCalendar(yr, mo, day, hr, min);
            Reminder temp = new Reminder(desc, alert);
            remList.add(temp);
            //set up the alert
            alarm.set(temp);
        }
        else remList.add(new Reminder(desc));
        
        //Save to file
        try {
            IO.writeToFile(allrems);
        } catch (IOException ex) {
            Logger.getLogger(AddReminder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Description of this command
    // Note: this is from Object, so don't redeclare it in MenuItem
    @Override
    public String toString() {
        return "Add a reminder";
    }    
}
