package use_case.journey;

import entity.Journey;
import entity.Node;
import entity.WebPage;
import entity.WikiHistory;

public interface JourneyDataAccessInterface {

    /**
     * Executes the Search use case: starts a new journey
     * @param r the input data
     */
    void setRootPage(WebPage r);

    void addNode(Node node);

    Journey getJourney();

    WikiHistory getWikiHistory();

    /**
     * Resets all of the attributes in the JourneyDAO - for when the user selects "save and close"
     */
    void reset();
}
