package interface_adapter.graph;

import entity.Graph;
import use_case.graph.GraphDataAccessInterface;

public class OldGraphState {
    private final GraphDataAccessInterface graphDataAccessInterface;

    public OldGraphState(GraphDataAccessInterface graphDataAccessInterface) {
        this.graphDataAccessInterface = graphDataAccessInterface;
    }

    public Graph getGraph() {
        return this.graphDataAccessInterface.getGraph();
    }
}