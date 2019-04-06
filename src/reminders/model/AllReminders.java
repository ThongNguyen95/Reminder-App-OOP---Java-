package reminders.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author villa
 */
public class AllReminders implements Serializable {
    private static final int NO_CHOICE = -1;
    private final List<ReminderList> allrems;
    private int chosenList;

    // Initialize reminders to empty list
    public AllReminders() {
        allrems = new ArrayList<>();
        chosenList = NO_CHOICE;    // no list chosen
    }

    // Add a new list of reminders at the end
    public void addCategory(String catName) {
        allrems.add(new ReminderList(catName));
    }
    
    // Getter for the lists
    public List<ReminderList> getCategories() {
        return allrems;
    }

    // set the "current" list
    public void setFocus(int index) {
        chosenList = index;
    }

    // Add a reminder to the "current" list
    public void addReminder(Reminder rem) {
        allrems.get(chosenList).add(rem);
    }

    // Get all reminders from today, regardless of category
    public List<Reminder> getTodays() {
        List<Reminder> result = new ArrayList<>();
        for (ReminderList remList: allrems)
            result.addAll(remList.getTodaysReminders());
        return result;
    }

    public ReminderList getCategory(int chosenList) {
        return allrems.get(chosenList);
    }
    
}
