package interface_adapter.graph;

import entity.Graph;
import use_case.graph.GraphDataAccessInterface;

public class GraphState {
    private final GraphDataAccessInterface graphDataAccessInterface;

    public GraphState(GraphDataAccessInterface graphDataAccessInterface) {
        this.graphDataAccessInterface = graphDataAccessInterface;
    }

    public Graph getGraph() {
        return this.graphDataAccessInterface.getGraph();
    }
}