package use_case.graph;

import entity.Graph;
import entity.Node;

public interface GraphDataAccessObject {

    Graph getGraph();

    void addNode(Node n);

}
