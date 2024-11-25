package interface_adapter.graph;

import use_case.graph.GraphInputBoundary;

/**
 * Controller for the Graph use case.
 */
public class GraphController {

    private final GraphInputBoundary graphInteractor;

    public GraphController(GraphInputBoundary graphInputBoundary1) {
        this.graphInteractor = graphInputBoundary1;
    }

    public void switchToRoot() {
        graphInteractor.switchToRoot();
    }
}
