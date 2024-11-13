package app;

import javax.swing.*;

/**
 * The Main class of our application.
 */
public class Main {
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addNavBarView()
                .addSearchView()
                .build();
        application.pack();
        application.setVisible(true);
    }
}
