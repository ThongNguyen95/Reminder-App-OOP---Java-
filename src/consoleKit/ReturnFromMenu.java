package consoleKit;

/**
 * Regular exit from a program
 * @author villa
 */
public class ReturnFromMenu implements MenuItem {
    private final String msg;
    private final MenuStack menus;
    
    //Initialize msg and menus variables
    public ReturnFromMenu(String prevMenuName, MenuStack _menus) {
        msg = prevMenuName;
        menus = _menus;
    }
    
    //Return to the previous Menu
    @Override
    public void execute() {
        menus.toPreviousMenu();
    }
    
    //Return the string to display on the menu
    @Override
    public String toString() {
        return "Return to main menu";
    }
    
}
