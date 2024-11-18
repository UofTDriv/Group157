package use_case.navBar;

public class NavBarInteractor implements NavBarInputBoundary {
    private final NavBarOutputBoundary navBarPresenter;

    public NavBarInteractor(NavBarOutputBoundary navBarPresenter) {
        this.navBarPresenter = navBarPresenter;
    }

    @Override
    public void switchToSearchView() {
        navBarPresenter.switchToSearchView();
    }

    @Override
    public void switchToJourneyView() {
        navBarPresenter.switchToJourneyView();
    }

    @Override
    public void switchToSaveView() {
        navBarPresenter.switchToSaveView();
    }

    @Override
    public void switchToOpenView() {
        navBarPresenter.switchToOpenView();
    }

    @Override
    public void switchToGraphView() {
        navBarPresenter.switchToGraphView();
    }
}
