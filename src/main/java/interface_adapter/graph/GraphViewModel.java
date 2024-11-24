package interface_adapter.graph;

import interface_adapter.ViewModel;
import use_case.graph.GraphDataAccessObject;

public class GraphViewModel extends ViewModel<GraphState> {

    private final GraphDataAccessObject graphDataAccessObject;

    public GraphViewModel(GraphDataAccessObject graphDataAccessObject) {
        super("Graph");
        this.graphDataAccessObject = graphDataAccessObject;
        setState(new GraphState(graphDataAccessObject));
    }
}
