package use_case.graph;

import entity.Graph;

/**
 * DAO for the Graph use case.
 */
public interface GraphDataAccessInterface {
    /**
     * Returns the underlying graph object of the current Journey
     * @return the underlying graph object corresponding to the displayed graph in GraphView.
     */
    Graph getGraph();
}
