package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuOptions {
    final public static ArrayList<MenuOption> data = new ArrayList<MenuOption>() {{
        add(new MenuOption(1, "List Books"));
        add(new MenuOption(2, "Checkout Book"));
        add(new MenuOption(3, "Return Book"));
        add(new MenuOption(4, "Quit"));
    }};
}
