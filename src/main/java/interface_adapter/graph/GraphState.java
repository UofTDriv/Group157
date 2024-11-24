package interface_adapter.graph;

import entity.Graph;
import use_case.graph.GraphDataAccessObject;

public class GraphState {
    private final GraphDataAccessObject graphDataAccessObject;

    public GraphState(GraphDataAccessObject graphDataAccessObject) {
        this.graphDataAccessObject = graphDataAccessObject;
    }

    public Graph getGraph() {
        return this.graphDataAccessObject.getGraph();
    }
}