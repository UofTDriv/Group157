package app;

import interface_adapter.NavBarViewModel;
import interface_adapter.search.SearchViewModel;
import view.NavBarView;
import view.SearchView;

import javax.swing.*;
import java.awt.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * This is done by adding each View and then adding related Use Cases.
 */
public class AppBuilder {
    private final JPanel mainWindowFrame = new JPanel();
    private final JPanel activeCardPanel = new JPanel();
    private final BorderLayout borderLayout = new BorderLayout();
    private final CardLayout cardLayout = new CardLayout();

    private NavBarView navBarView;
    private NavBarViewModel navBarViewModel;
    private SearchView searchView;
    private SearchViewModel searchViewModel;

    public AppBuilder() {
        mainWindowFrame.setLayout(borderLayout);
        activeCardPanel.setLayout(cardLayout);
    }

    public AppBuilder addNavBarView() {
        navBarViewModel = new NavBarViewModel();
        navBarView = new NavBarView(navBarViewModel);
        mainWindowFrame.add(navBarView, BorderLayout.NORTH);
        return this;
    }

    public AppBuilder addSearchView() {
        searchViewModel = new SearchViewModel();
        searchView = new SearchView(searchViewModel);
        activeCardPanel.add(searchView);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Wikipedia Journey Viewer");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        activeCardPanel.add(searchView);

        mainWindowFrame.add(activeCardPanel, BorderLayout.CENTER);

        application.add(mainWindowFrame);

        return application;
    }
}
