package app;

import data_access.InMemoryJourneyDataAccessObject;
import interface_adapter.navBar.NavBarController;
import interface_adapter.navBar.NavBarPresenter;
import interface_adapter.navBar.NavBarViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.graph.GraphViewModel;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.open.OpenViewModel;
import interface_adapter.save.SaveViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import use_case.navBar.NavBarInputBoundary;
import use_case.navBar.NavBarInteractor;
import use_case.navBar.NavBarOutputBoundary;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import view.*;

import javax.swing.*;
import java.awt.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * This is done by adding each View and then adding related Use Cases.
 */
public class AppBuilder {
    private final JPanel views = new JPanel();
    private final CardLayout cardLayout = new CardLayout();

    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(views, cardLayout, viewManagerModel);

    private SearchDataAccessInterface searchDAO;
    private InMemoryJourneyDataAccessObject memoryDAO;

    private NavBarViewModel navBarViewModel;
    private NavBarView navBarView;
    private SearchViewModel searchViewModel;
    private SearchView searchView;
    private JourneyViewModel journeyViewModel;
    private JourneyView journeyView;
    private SaveViewModel saveViewModel;
    private SaveView saveView;
    private OpenViewModel openViewModel;
    private OpenView openView;
    private GraphViewModel graphViewModel;
    private GraphView graphView;

    public AppBuilder() {
        views.setLayout(cardLayout);
    }

    public AppBuilder addSearchDAO(SearchDataAccessInterface dataAccessObject) {
        this.searchDAO = dataAccessObject;
        return this;
    }

    public AppBuilder addMemoryDAO(InMemoryJourneyDataAccessObject dataAccessObject) {
        this.memoryDAO = dataAccessObject;
        return this;
    }

    public AppBuilder addNavBarView() {
        navBarViewModel = new NavBarViewModel();
        navBarView = new NavBarView(navBarViewModel);
        return this;
    }

    public AppBuilder addSearchView() {
        searchViewModel = new SearchViewModel();
        searchView = new SearchView(searchViewModel);
        views.add(searchView, searchView.getViewName());
        return this;
    }

    public AppBuilder addJourneyView() {
        journeyViewModel = new JourneyViewModel();
        journeyView = new JourneyView(journeyViewModel);
        views.add(journeyView, journeyView.getViewName());
        return this;
    }

    public AppBuilder addSaveView() {
        saveViewModel = new SaveViewModel();
        saveView = new SaveView(saveViewModel);
        views.add(saveView, saveView.getViewName());
        return this;
    }

    public AppBuilder addOpenView() {
        openViewModel = new OpenViewModel();
        openView = new OpenView(openViewModel);
        views.add(openView, openView.getViewName());
        return this;
    }

    public AppBuilder addGraphView() {
        graphViewModel = new GraphViewModel();
        graphView = new GraphView(graphViewModel);
        views.add(graphView, graphView.getViewName());
        return this;
    }

    public AppBuilder addNavBarUseCase() {
        final NavBarOutputBoundary navBarPresenter = new NavBarPresenter(viewManagerModel, navBarViewModel,
                searchViewModel, journeyViewModel, saveViewModel, openViewModel, graphViewModel);
        final NavBarInputBoundary navBarInputBoundary = new NavBarInteractor(navBarPresenter, memoryDAO);
        final NavBarController controller = new NavBarController(navBarInputBoundary);
        navBarView.setController(controller);
        return this;
    }

    public AppBuilder addSearchUseCase() {
        final SearchOutputBoundary searchPresenter = new SearchPresenter(searchViewModel, viewManagerModel,
                journeyViewModel, saveViewModel, navBarViewModel);
        final SearchInputBoundary searchInputBoundary = new SearchInteractor(searchPresenter, searchDAO, memoryDAO);
        final SearchController controller = new SearchController(searchInputBoundary);
        searchView.setSearchController(controller);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Wikipedia Journey Viewer");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setLayout(new BorderLayout());

        application.add(views, BorderLayout.CENTER);
        application.add(navBarView, BorderLayout.NORTH);

        viewManagerModel.setState(searchView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
