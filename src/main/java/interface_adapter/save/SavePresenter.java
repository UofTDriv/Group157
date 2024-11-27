package interface_adapter.save;

import interface_adapter.ViewManagerModel;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.navBar.NavBarState;
import interface_adapter.navBar.NavBarViewModel;
import interface_adapter.search.SearchViewModel;
import use_case.save.SaveOutputBoundary;
import use_case.save.SaveOutputData;

public class SavePresenter implements SaveOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final SaveViewModel saveViewModel;
    private final NavBarViewModel navBarViewModel;

    public SavePresenter(SaveViewModel saveViewModel,
                         ViewManagerModel viewManagerModel,
                         NavBarViewModel navBarViewModel) {

        this.viewManagerModel = viewManagerModel;
        this.saveViewModel = saveViewModel;
        this.navBarViewModel = navBarViewModel;
    }

    @Override
    public void prepareSuccessViewContinue(SaveOutputData saveOutputData) {

    }

    @Override
    public void prepareFailViewContinue(String errorMessage) {

    }

    @Override
    public void prepareSuccessViewClose(SaveOutputData saveOutputData) {
        final NavBarState navBarState = navBarViewModel.getState();
        navBarState.resetJourney();
        this.navBarViewModel.setState(navBarState);
        navBarViewModel.firePropertyChanged("state");

        final SaveState saveState = saveViewModel.getState();
        saveState.setRootArticleTitle("blah blah");
        this.saveViewModel.setState(saveState);
        saveViewModel.firePropertyChanged("state");
    }

    @Override
    public void prepareFailViewClose(String errorMessage) {
        // THIS IS TEMPORARY
        final SaveState saveState = saveViewModel.getState();
        saveState.setRootArticleTitle(errorMessage);
        this.saveViewModel.setState(saveState);
        saveViewModel.firePropertyChanged("state");
    }
}
