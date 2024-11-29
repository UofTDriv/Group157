package interface_adapter.graph;

import use_case.graph.GraphInputBoundary;
import use_case.graph.GraphInputData;

/**
 * Controller for the Graph use case.
 */
public class GraphController {

    private final GraphInputBoundary graphInteractor;

    public GraphController(GraphInputBoundary graphInputBoundary1) {
        this.graphInteractor = graphInputBoundary1;
    }

    public void execute(String clickedNode) {
        GraphInputData inputData = new GraphInputData(clickedNode);
        graphInteractor.execute(inputData);
    }
}
