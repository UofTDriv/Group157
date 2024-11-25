package use_case.journey;

import entity.Journey;
import entity.Node;
import entity.WebPage;

public interface JourneyDataAccessInterface {

    /**
     * Executes the Search use case: starts a new journey
     * @param r the input data
     */
    void setRootPage(WebPage r);

    void addNode(Node node);

    Journey getJourney();
}
