package reminders.consoleview;

import static consoleKit.Console.getChoice;
import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.QuitCmd;
import consoleKit.ReturnFromMenu;
import reminders.model.AllReminders;
import reminders.model.ReminderList;

/**
 *
 * @author villa
 */
public class ChooseCategory implements MenuItem {
    private AllReminders all;
    private Menu mainMenu;
    private MenuStack menus;

    public ChooseCategory(AllReminders allrems, Menu _mainMenu, MenuStack _menus) {
        all = allrems;
        mainMenu = _mainMenu;
        menus = _menus;
    }

    // Choose the category to work with and switch to a menu for individual categories
    @Override
    public void execute() {
        int chosenListIndex = getChoice(all.getCategories());
        all.setFocus(chosenListIndex);
        
        // add new menu for this list
        ReminderList chosenList = all.getCategory(chosenListIndex);
        Menu subMenu = new Menu(chosenList.toString(), menus);
        subMenu.add(new QuitCmd());
        subMenu.add(new ReturnFromMenu(mainMenu.toString(), menus));
        subMenu.add(new DisplayCategory(chosenList));
        subMenu.add(new AddReminder(chosenList,all));
        //subMenu.execute();
    }

    // Description of this command
    @Override
    public String toString() {
        return "Choose a category to work with ";
    }    
    
}
