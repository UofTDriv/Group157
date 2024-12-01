package app;


import data_access.InMemoryJourneyDataAccessObject;
import interface_adapter.add.AddController;
import interface_adapter.add.AddPresenter;
import interface_adapter.graph.GraphController;
import interface_adapter.graph.GraphPresenter;
import interface_adapter.journey.JourneyController;
import interface_adapter.journey.JourneyPresenter;
import interface_adapter.navBar.NavBarController;
import interface_adapter.navBar.NavBarPresenter;
import interface_adapter.navBar.NavBarViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.graph.GraphViewModel;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.open.OpenController;
import interface_adapter.open.OpenPresenter;
import interface_adapter.open.OpenViewModel;
import interface_adapter.save.*;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import use_case.add.AddInputBoundary;
import use_case.add.AddInteractor;
import use_case.add.AddOutputBoundary;
import use_case.graph.GraphInputBoundary;
import use_case.graph.GraphInteractor;
import use_case.graph.GraphOutputBoundary;
import use_case.journey.JourneyInputBoundary;
import use_case.journey.JourneyInteractor;
import use_case.journey.JourneyOutputBoundary;
import use_case.navBar.NavBarInputBoundary;
import use_case.navBar.NavBarInteractor;
import use_case.navBar.NavBarOutputBoundary;
import use_case.open.OpenInputBoundary;
import use_case.open.OpenInteractor;
import use_case.open.OpenOutputBoundary;
import use_case.save.SaveDataAccessInterface;
import use_case.save.SaveInputBoundary;
import use_case.save.SaveInteractor;
import use_case.save.SaveOutputBoundary;
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
    private SaveDataAccessInterface saveDAO;

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

    public AppBuilder addSaveDAO(SaveDataAccessInterface dataAccessObject) {
        this.saveDAO = dataAccessObject;
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
        graphViewModel = new GraphViewModel(memoryDAO.getGraph());
        graphView = new GraphView(graphViewModel);
        views.add(graphView, graphView.getViewName());
        return this;
    }

    public AppBuilder addGraphUseCase() {
        final GraphOutputBoundary graphPresenter = new GraphPresenter(graphViewModel, viewManagerModel, navBarViewModel, journeyViewModel);
        final GraphInputBoundary graphInputBoundary = new GraphInteractor(graphPresenter, memoryDAO, memoryDAO); // is this right?
        final GraphController controller = new GraphController(graphInputBoundary);
        graphView.setController(controller);
        return this;
    }

    public AppBuilder addAddUseCase() {
        final AddOutputBoundary addPresenter = new AddPresenter(graphViewModel, viewManagerModel, journeyViewModel);
        final AddInputBoundary addInteractor = new AddInteractor(addPresenter, memoryDAO);
        final AddController controller = new AddController(addInteractor);
        journeyView.setAddController(controller);
        return this;
    }

    public AppBuilder addJourneyUseCase() {
        final JourneyOutputBoundary journeyPresenter = new JourneyPresenter(journeyViewModel, navBarViewModel);
        final JourneyInputBoundary journeyInteractor = new JourneyInteractor(searchDAO, memoryDAO, journeyPresenter);
        final JourneyController controller = new JourneyController(journeyInteractor);
        journeyView.setController(controller);
        return this;
    }

    public AppBuilder addSaveUseCase() {
        final SaveOutputBoundary closePresenter = new SavePresenterClose(saveViewModel, viewManagerModel, navBarViewModel,
                openViewModel, journeyViewModel);
        final SaveOutputBoundary continuePresenter = new SavePresenterContinue(saveViewModel, viewManagerModel, navBarViewModel,
                openViewModel, journeyViewModel);
        final SaveInputBoundary saveInteractor = new SaveInteractor(closePresenter, continuePresenter, saveDAO, memoryDAO);
        final SaveController controller = new SaveController(saveInteractor);
        saveView.setSaveController(controller);
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

    public AppBuilder addOpenUseCase() {
        final OpenOutputBoundary openPresenter = new OpenPresenter(viewManagerModel, navBarViewModel,
                openViewModel, journeyViewModel);
        final OpenInputBoundary openInteractor = new OpenInteractor(openPresenter, saveDAO, memoryDAO);
        final OpenController openController = new OpenController(openInteractor);
        openView.setOpenController(openController);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Wikipedia Journey Viewer");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle usableBounds = env.getMaximumWindowBounds();
        application.setMaximizedBounds(usableBounds);
        application.setExtendedState(JFrame.MAXIMIZED_BOTH);

        application.setLayout(new BorderLayout());

        application.add(views, BorderLayout.CENTER);
        application.add(navBarView, BorderLayout.NORTH);

        application.setBackground(SwingStyle.background);

        viewManagerModel.setState(searchView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
