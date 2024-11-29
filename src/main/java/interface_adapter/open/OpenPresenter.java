package interface_adapter.open;

import interface_adapter.ViewManagerModel;
import interface_adapter.navBar.NavBarViewModel;
import use_case.open.OpenInputData;
import use_case.open.OpenOutputBoundary;
import use_case.open.OpenOutputData;
import use_case.save.SaveOutputData;

public class OpenPresenter implements OpenOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final NavBarViewModel navBarViewModel;
    private final OpenViewModel openViewModel;

    public OpenPresenter(ViewManagerModel viewManagerModel,
                         NavBarViewModel navBarViewModel,
                         OpenViewModel openViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.navBarViewModel = navBarViewModel;
        this.openViewModel = openViewModel;
    }

    @Override
    public void prepareSuccessView(OpenOutputData openOutputData) {

    }

    @Override
    public void prepareFailView() {

    }
}
