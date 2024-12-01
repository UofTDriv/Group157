package use_case.navBar;

import use_case.journey.JourneyDataAccessInterface;

/**
 * The NavBar Interactor.
 */
public class NavBarInteractor implements NavBarInputBoundary {
    private final NavBarOutputBoundary navBarPresenter;
    private final JourneyDataAccessInterface journeyDataAccessInterface;

    public NavBarInteractor(NavBarOutputBoundary navBarPresenter,
                            JourneyDataAccessInterface journeyDataAccessInterface) {
        this.navBarPresenter = navBarPresenter;
        this.journeyDataAccessInterface = journeyDataAccessInterface;
    }

    @Override
    public void switchToSearchView() {
        navBarPresenter.switchToSearchView();
    }

    @Override
    public void switchToJourneyView() {
        if (journeyDataAccessInterface.getJourney() != null) {
            navBarPresenter.switchToJourneyView();
        } else navBarPresenter.prepareFailView("No journey open to view");
    }

    @Override
    public void switchToSaveView() {
        if (journeyDataAccessInterface.getJourney() != null) {
            navBarPresenter.switchToSaveView();
        } else navBarPresenter.prepareFailView("No journey open to save");
    }

    @Override
    public void switchToOpenView() {
        navBarPresenter.switchToOpenView();
    }

    @Override
    public void switchToGraphView() {
        if (journeyDataAccessInterface.getJourney() != null) {
            navBarPresenter.switchToGraphView();
        } else navBarPresenter.prepareFailView("No journey open with a graph");
    }
}
