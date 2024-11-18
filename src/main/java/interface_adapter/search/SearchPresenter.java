package interface_adapter.search;

import entity.WebPage;
import interface_adapter.ViewManagerModel;
import interface_adapter.journey.JourneyState;
import interface_adapter.journey.JourneyViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

/**
 * Presenter for the search use case.
 */
public class SearchPresenter implements SearchOutputBoundary {

    private final SearchViewModel searchViewModel;
    private final ViewManagerModel viewManagerModel;
    private final JourneyViewModel journeyViewModel;

    public SearchPresenter(SearchViewModel searchViewModel,
                           ViewManagerModel viewManagerModel,
                           JourneyViewModel journeyViewModel) {
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
        this.journeyViewModel = journeyViewModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData outputData) {
        final JourneyState journeyState = journeyViewModel.getState();
        journeyState.setCurrentPage(new WebPage(outputData.getTitle(), outputData.getBody()));
        this.journeyViewModel.setState(journeyState);
        journeyViewModel.firePropertyChanged();

        viewManagerModel.setState(journeyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // TODO: Implement this method
    }
}
