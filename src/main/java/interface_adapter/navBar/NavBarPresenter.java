package interface_adapter.navBar;

import interface_adapter.ViewManagerModel;
import interface_adapter.graph.GraphViewModel;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.open.OpenViewModel;
import interface_adapter.save.SaveViewModel;
import interface_adapter.search.SearchViewModel;
import use_case.navBar.NavBarOutputBoundary;

public class NavBarPresenter implements NavBarOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final NavBarViewModel navBarViewModel;
    private final SearchViewModel searchViewModel;
    private final JourneyViewModel journeyViewModel;
    private final SaveViewModel saveViewModel;
    private final OpenViewModel openViewModel;
    private final GraphViewModel graphViewModel;

    public NavBarPresenter(ViewManagerModel viewManagerModel, NavBarViewModel navBarViewModel,
                           SearchViewModel searchViewModel,
                           JourneyViewModel journeyViewModel,
                           SaveViewModel saveViewModel,
                           OpenViewModel openViewModel,
                           GraphViewModel graphViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.navBarViewModel = navBarViewModel;
        this.searchViewModel = searchViewModel;
        this.journeyViewModel = journeyViewModel;
        this.saveViewModel = saveViewModel;
        this.openViewModel = openViewModel;
        this.graphViewModel = graphViewModel;
    }

    @Override
    public void switchToSearchView() {
        viewManagerModel.setState(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToJourneyView() {
        viewManagerModel.setState(journeyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToSaveView() {
        viewManagerModel.setState(saveViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToOpenView() {
        viewManagerModel.setState(openViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToGraphView() {
        viewManagerModel.setState(graphViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final NavBarState navBarState = navBarViewModel.getState();
        navBarState.setSwitchError(errorMessage);
        navBarViewModel.firePropertyChanged("error");
    }
}
