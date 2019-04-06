package consoleKit;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Supports nested menus
 * @author villa
 */
public class MenuStack {
    // Create a stack of menus
    ArrayDeque<Menu> menus;
    
    // Initialize the empty stack
    public MenuStack() {
        menus = new ArrayDeque<>();
    }
    
    // Get the Menu item on the top of the stack
    public Menu getCurrent() {
        return menus.getFirst();
    }
    
    // Get the Menu item on the top of the stack
    public void add(Menu menu) {
        menus.addFirst(menu);
    }
    
    // Return to the previous menu by removing the menu on top of the stack
    public void toPreviousMenu() {
        menus.removeFirst();
    }
    
    // Execute the current menu on top of the stack
    public void run() {
        if (!menus.isEmpty()) {
            this.getCurrent().execute();
        }
    }
    
}
