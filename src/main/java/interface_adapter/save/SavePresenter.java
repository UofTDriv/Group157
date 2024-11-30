package interface_adapter.save;

import interface_adapter.ViewManagerModel;
import interface_adapter.journey.JourneyState;
import interface_adapter.journey.JourneyViewModel;
import interface_adapter.navBar.NavBarState;
import interface_adapter.navBar.NavBarViewModel;
import interface_adapter.open.OpenState;
import interface_adapter.open.OpenViewModel;
import interface_adapter.search.SearchViewModel;
import use_case.save.SaveOutputBoundary;
import use_case.save.SaveOutputData;

public class SavePresenter implements SaveOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final SaveViewModel saveViewModel;
    private final NavBarViewModel navBarViewModel;
    private final OpenViewModel openViewModel;
    private final JourneyViewModel journeyViewModel;

    public SavePresenter(SaveViewModel saveViewModel,
                         ViewManagerModel viewManagerModel,
                         NavBarViewModel navBarViewModel,
                         OpenViewModel openViewModel,
                         JourneyViewModel journeyViewModel) {

        this.viewManagerModel = viewManagerModel;
        this.saveViewModel = saveViewModel;
        this.navBarViewModel = navBarViewModel;
        this.openViewModel = openViewModel;
        this.journeyViewModel = journeyViewModel;
    }

    @Override
    public void prepareSuccessView(SaveOutputData saveOutputData) {
        final OpenState openState = openViewModel.getState();
        openState.updateHistory(saveOutputData.getSaveTitle(), saveOutputData.getWikiHistoryToBeSaved());
        this.openViewModel.setState(openState);
        openViewModel.firePropertyChanged("state");

        viewManagerModel.setState(journeyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final SaveState saveState = saveViewModel.getState();
        saveState.setRootArticleTitle(errorMessage);
        this.saveViewModel.setState(saveState);
        saveViewModel.firePropertyChanged("state");
    }
}
