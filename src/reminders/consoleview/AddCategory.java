package reminders.consoleview;

import static consoleKit.Console.STDIN;
import consoleKit.IO;
import consoleKit.MenuItem;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reminders.model.AllReminders;

/**
 * Add a new list of reminders
 * @author villa
 */
public class AddCategory implements MenuItem {
    private AllReminders all;

    public AddCategory(AllReminders allrems) {
        all = allrems;
    }

    // Get name of new category and add it
    @Override
    public void execute() {
        System.out.print("Enter the name of the new category: ");
        String name = STDIN.next();
        all.addCategory(name);
        
        //Write to file
        try {
            IO.writeToFile(all);
        } catch (IOException ex) {
            Logger.getLogger(AddCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Description of this command
    @Override
    public String toString() {
        return "Add a new category of reminders";
    }    
}
