package use_case.journey;

import entity.Journey;
import entity.Node;

public interface JourneyDataAccessInterface {

    /**
     * Executes the Search use case: starts a new journey
     * @param rootNode the input data
     */
    void setRootPage(Node rootNode);

    Journey getJourney();
}
