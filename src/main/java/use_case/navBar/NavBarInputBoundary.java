package use_case.navBar;

/**
 * Input Boundary for actions which are related to switching views.
 */
public interface NavBarInputBoundary {
    /**
     * Executes the switch to search view use case.
     */
    void switchToSearchView();

    /**
     * Executes the switch to search view use case.
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
}
