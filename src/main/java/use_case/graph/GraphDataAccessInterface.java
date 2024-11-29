package use_case.graph;

import entity.Graph;
import entity.Node;

public interface GraphDataAccessInterface {

    Graph getGraph();

    Node getNode(String title);

    void setNewJourneyCurrentNode(Node node);
}
