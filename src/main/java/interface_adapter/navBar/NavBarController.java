package interface_adapter.navBar;

import use_case.navBar.NavBarInputBoundary;

public class NavBarController {

    private final NavBarInputBoundary navBarInteractor;

    public NavBarController(NavBarInputBoundary navBarInteractor) {
        this.navBarInteractor = navBarInteractor;
    }

    public void switchToSearchView() {
        navBarInteractor.switchToSearchView();
    }

    public void switchToJourneyView() {
        navBarInteractor.switchToJourneyView();
    }

    public void switchToSaveView() {
        navBarInteractor.switchToSaveView();
    }

    public void switchToOpenView() {
        navBarInteractor.switchToOpenView();
    }

    public void switchToGraphView() {
        navBarInteractor.switchToGraphView();
    }
}
