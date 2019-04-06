package reminders.consoleview;

import consoleKit.IO;
import consoleKit.Menu;
import consoleKit.MenuStack;
import consoleKit.QuitCmd;
import java.io.IOException;
import reminders.model.AllReminders;
import reminders.model.ReminderList;

/**
 *
 * @author villa
 */
public class RemApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MenuStack menus = new MenuStack();
        AllReminders allrems;
        // Load from file
        try {
        allrems = IO.readFromFile();
        } catch (ClassNotFoundException | IOException o) {
            allrems = new AllReminders();
            allrems.addCategory("Personal");
        }
        
        Menu mainMenu = new Menu("main menu", menus);
        mainMenu.add(new QuitCmd());
        mainMenu.add(new TodaysReminders(allrems));
        mainMenu.add(new AddCategory(allrems));
        mainMenu.add(new ChooseCategory(allrems, mainMenu, menus));
        
        System.out.println("Reminders, version 0.1");
        while (true)
            menus.run();
        //
        
    }
    
}
