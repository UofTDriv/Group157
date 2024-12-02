package use_case.graph;

import entity.Graph;
import entity.Journey;
import entity.Node;
import entity.WikiHistory;

public interface GraphDataAccessInterface {

    Graph getGraph();

    Journey getJourney();

    WikiHistory getWikiHistory();

    Node getNode(String title);

    void setNewJourneyCurrentNode(Node node);
}
