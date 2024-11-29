package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.graph.GraphState;
import interface_adapter.graph.GraphViewModel;
import interface_adapter.journey.JourneyState;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.navBar.NavBarState;
import interface_adapter.navBar.NavBarViewModel;
import interface_adapter.save.SaveState;
import interface_adapter.save.SaveViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

/**
 * Presenter for the search use case.
 */
public class SearchPresenter implements SearchOutputBoundary {

    private final SearchViewModel searchViewModel;
    private final ViewManagerModel viewManagerModel;
    private final JourneyViewModel journeyViewModel;
    private final SaveViewModel saveViewModel;
    private final NavBarViewModel navBarViewModel;

    public SearchPresenter(SearchViewModel searchViewModel,
                           ViewManagerModel viewManagerModel,
                           JourneyViewModel journeyViewModel,
                           SaveViewModel saveViewModel,
                           NavBarViewModel navBarViewModel) {
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
        this.journeyViewModel = journeyViewModel;
        this.saveViewModel = saveViewModel;
        this.navBarViewModel = navBarViewModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData outputData) {
        final JourneyState journeyState = journeyViewModel.getState();
        journeyState.setCurrentPage(outputData.getRootPage());
        this.journeyViewModel.setState(journeyState);
        journeyViewModel.firePropertyChanged();

        final NavBarState navBarState = navBarViewModel.getState();
        navBarState.setJourney(outputData.getRootTitle());
        this.navBarViewModel.setState(navBarState);
        navBarViewModel.firePropertyChanged("state");

        final SaveState saveState = saveViewModel.getState();
        saveState.setRootArticleTitle(outputData.getRootTitle());
        this.saveViewModel.setState(saveState);
        saveViewModel.firePropertyChanged("state");

        viewManagerModel.setState(journeyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final SearchState searchState = searchViewModel.getState();
        searchState.setSearchError(errorMessage);
        searchViewModel.firePropertyChanged("error");
    }
}
