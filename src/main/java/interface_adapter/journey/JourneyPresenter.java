package interface_adapter.journey;

import entity.WebPage;
import use_case.journey.JourneyOutputBoundary;
import use_case.journey.JourneyOutputData;

public class JourneyPresenter implements JourneyOutputBoundary {
    private final JourneyViewModel journeyViewModel;

    public JourneyPresenter(JourneyViewModel journeyViewModel) {
        this.journeyViewModel = journeyViewModel;
    }

    @Override
    public void prepareSuccessView(JourneyOutputData outputData) {
        final JourneyState journeyState = journeyViewModel.getState();
        journeyState.setCurrentPage(outputData.getPage());
        this.journeyViewModel.setState(journeyState);
        journeyViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
