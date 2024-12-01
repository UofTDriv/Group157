package use_case.navBar;

/**
 * The output boundary for the NavBar Use Case.
 */
public interface NavBarOutputBoundary {
    /**
     * Executes the panel switch to search view use case.
     */
    void switchToSearchView();
    /**
     * Executes the panel switch to journey view use case.
     */
    void switchToJourneyView();
    /**
     * Executes the panel switch to save view use case.
     */
    void switchToSaveView();
    /**
     * Executes the panel switch to open view use case.
     */
    void switchToOpenView();
    /**
     * Executes the panel switch to graph view use case.
     */
    void switchToGraphView();
    /**
     * Prepares the failure view for the navbar use case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
