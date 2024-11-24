package use_case.navBar;

public interface NavBarOutputBoundary {
    /**
     * Executes the switch to search view use case.
     */
    void switchToSearchView();

    /**
     * Executes the switch to journey view use case.
     */
    void switchToJourneyView();

    /**
     * Executes the switch to save view use case.
     */
    void switchToSaveView();

    /**
     * Executes the switch to open view use case.
     */
    void switchToOpenView();

    /**
     * Executes the switch to graph view use case.
     */
    void switchToGraphView();

    /**
     * Prepares the failure view for the navbar use case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
