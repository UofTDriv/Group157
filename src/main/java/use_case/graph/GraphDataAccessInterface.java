package use_case.graph;

import entity.Graph;
import entity.Node;

public interface GraphDataAccessInterface {

    Graph getGraph();

    void addNodeToGraph(String n);

    void addEdge(String from, String to);

}
