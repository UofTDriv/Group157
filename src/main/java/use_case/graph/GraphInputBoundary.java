package use_case.graph;

/**
 * Input Boundary for the graph use case.
 */
public interface GraphInputBoundary {

    /**
     * Adds a node to the existing graph
     */
    void addNode(NodeInputData nodeInputData);

    void switchToRoot();

//    void addEdge(NodeInputData nodeInputData);

//    void getNode(NodeInputData nodeInputData);

}
