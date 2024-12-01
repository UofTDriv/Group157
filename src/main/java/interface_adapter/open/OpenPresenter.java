package interface_adapter.open;

import interface_adapter.ViewManagerModel;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.navBar.NavBarState;
import interface_adapter.navBar.NavBarViewModel;
import use_case.open.OpenOutputBoundary;
import use_case.open.OpenOutputData;

public class OpenPresenter implements OpenOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final NavBarViewModel navBarViewModel;
    private final OpenViewModel openViewModel;
    private final JourneyViewModel journeyViewModel;

    public OpenPresenter(ViewManagerModel viewManagerModel,
                         NavBarViewModel navBarViewModel,
                         OpenViewModel openViewModel,
                         JourneyViewModel journeyViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.navBarViewModel = navBarViewModel;
        this.openViewModel = openViewModel;
        this.journeyViewModel = journeyViewModel;
    }

    @Override
    public void prepareSuccessView(OpenOutputData openOutputData) {
        NavBarState navBarState = navBarViewModel.getState();
        navBarState.setJourney(openOutputData.getWikiHistoryNodes().get(0).getTitle());
        this.navBarViewModel.setState(navBarState);
        navBarViewModel.firePropertyChanged("state");

        viewManagerModel.setState(journeyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String message) {
        System.out.println(message);
    }
}
