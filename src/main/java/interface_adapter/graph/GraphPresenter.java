package interface_adapter.graph;

import interface_adapter.ViewManagerModel;
import interface_adapter.journey.JourneyState;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.navBar.NavBarState;
import interface_adapter.navBar.NavBarViewModel;
import use_case.graph.GraphOutputBoundary;
import use_case.graph.GraphOutputData;

public class GraphPresenter implements GraphOutputBoundary {
    private final GraphViewModel viewModel;
    private final ViewManagerModel viewManagerModel;
    private final NavBarViewModel navBarViewModel;
    private final JourneyViewModel journeyViewModel;

    public GraphPresenter(GraphViewModel viewModel,
                          ViewManagerModel viewManagerModel,
                          NavBarViewModel navBarViewModel,
                          JourneyViewModel journeyViewModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.navBarViewModel = navBarViewModel;
        this.journeyViewModel = journeyViewModel;
    }

    @Override
    public void prepareSuccessView(GraphOutputData data) {
        JourneyState journeyState = journeyViewModel.getState();
        journeyState.setCurrentPage(data.getTitle(), data.getContent());
        journeyViewModel.setState(journeyState);
        journeyViewModel.firePropertyChanged("state");

        NavBarState navBarState = navBarViewModel.getState();
        navBarState.setJourneyPage(data.getTitle());
        navBarViewModel.setState(navBarState);
        navBarViewModel.firePropertyChanged("state");

        viewManagerModel.setState(journeyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
