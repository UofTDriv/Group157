package use_case.journey;

import entity.Journey;
import entity.Node;
import entity.WikiHistory;

/**
 * DAO for the fetching the current journey.
 */
public interface JourneyDataAccessInterface {

    /**
     * Executes the Search use case: starts a new journey
     * @param rootNode the input data
     */
    void setRootNode(Node rootNode);
    /**
     * Returns the current journey of the application.
     * @return the journey object that's currently being used to display and keep track of the current page
     */
    Journey getJourney();
    /**
     * Returns the WikiHistory for the current journey of the application.
     * @return the WikiHistory object containing all the previously opened pages as nodes.
     */
    WikiHistory getWikiHistory();
    /**
     * Resets all attributes in memory contributing to the current Journey - for when the user selects "save and close"
     */
    void reset();
}
