package use_case.navBar;

import use_case.journey.JourneyDataAccessObject;

public class NavBarInteractor implements NavBarInputBoundary {
    private final NavBarOutputBoundary navBarPresenter;
    private final JourneyDataAccessObject journeyDataAccessObject;

    public NavBarInteractor(NavBarOutputBoundary navBarPresenter,
                            JourneyDataAccessObject journeyDataAccessObject) {
        this.navBarPresenter = navBarPresenter;
        this.journeyDataAccessObject = journeyDataAccessObject;
    }

    @Override
    public void switchToSearchView() {
        navBarPresenter.switchToSearchView();
    }

    @Override
    public void switchToJourneyView() {
        if (journeyDataAccessObject.getJourney() != null) {
            navBarPresenter.switchToJourneyView();
        } else navBarPresenter.prepareFailView("No journey open to view");
    }

    @Override
    public void switchToSaveView() {
        if (journeyDataAccessObject.getJourney() != null) {
            navBarPresenter.switchToSaveView();
        } else navBarPresenter.prepareFailView("No journey open to save");
    }

    @Override
    public void switchToOpenView() {
        navBarPresenter.switchToOpenView();
    }

    @Override
    public void switchToGraphView() {
        if (journeyDataAccessObject.getJourney() != null) {
            navBarPresenter.switchToGraphView();
        } else navBarPresenter.prepareFailView("No journey open with a graph");
    }
}
