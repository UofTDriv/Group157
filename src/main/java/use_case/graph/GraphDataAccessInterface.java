package use_case.graph;

import entity.Graph;
import entity.Node;

public interface GraphDataAccessInterface {

    Graph getGraph();

    void addNode(Node n);

}
