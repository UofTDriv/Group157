package interface_adapter.journey;

import entity.WebPage;
import interface_adapter.navBar.NavBarState;
import interface_adapter.navBar.NavBarViewModel;
import use_case.journey.JourneyOutputBoundary;
import use_case.journey.JourneyOutputData;

public class JourneyPresenter implements JourneyOutputBoundary {
    private final JourneyViewModel journeyViewModel;
    private final NavBarViewModel navBarViewModel;

    public JourneyPresenter(JourneyViewModel journeyViewModel, NavBarViewModel navBarViewModel) {
        this.journeyViewModel = journeyViewModel;
        this.navBarViewModel = navBarViewModel;
    }

    @Override
    public void prepareSuccessView(JourneyOutputData outputData) {
        final JourneyState journeyState = journeyViewModel.getState();
        journeyState.setCurrentPage(outputData.getPage());
        this.journeyViewModel.setState(journeyState);
        journeyViewModel.firePropertyChanged();

        final NavBarState navBarState = navBarViewModel.getState();
        navBarState.setJourneyPage(outputData.getTitle());
        this.navBarViewModel.setState(navBarState);
        navBarViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
