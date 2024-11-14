package app;

import interface_adapter.NavBarViewModel;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.search.SearchViewModel;
import view.JourneyView;
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
    private final JPanel views = new JPanel();

    private NavBarViewModel navBarViewModel;
    private NavBarView navBarView;
    private SearchViewModel searchViewModel;
    private SearchView searchView;
    private JourneyViewModel journeyViewModel;
    private JourneyView journeyView;

    public AppBuilder() {
        mainWindowFrame.setLayout(new BorderLayout());
        views.setLayout(new CardLayout());
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
        views.add(searchView);
        return this;
    }

    public AppBuilder addJourneyView() {
        this.journeyViewModel = new JourneyViewModel();
        journeyView = new JourneyView(journeyViewModel);
        views.add(journeyView);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Wikipedia Journey Viewer");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainWindowFrame.add(views, BorderLayout.CENTER);

        application.add(mainWindowFrame);

        return application;
    }
}
