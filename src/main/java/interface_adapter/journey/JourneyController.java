package interface_adapter.journey;

import use_case.journey.JourneyInputBoundary;
import use_case.journey.JourneyInputData;

/**
 * Controller for the Journey use case.
 */
public class JourneyController {
    private final JourneyInputBoundary journeyInteractor;

    public JourneyController(JourneyInputBoundary journeyInteractor) {
        this.journeyInteractor = journeyInteractor;
    }

    /**
     * Executes the journey Use Case
     * @param link the link to the wikipedia article that the user has clicked on
     */
    public void addNewNode(String link) {
        link = link.replaceAll("^/wiki/", "");

        final JourneyInputData journeyInputData = new JourneyInputData(link);

        journeyInteractor.execute(journeyInputData);
    }
}
