package interface_adapter.add;

import interface_adapter.ViewModel;
import use_case.graph.GraphDataAccessInterface;

public class GraphViewModel extends ViewModel<GraphState> {

    private final GraphDataAccessInterface graphDataAccessInterface;

    public GraphViewModel(GraphDataAccessInterface graphDataAccessInterface) {
        super("Graph");
        this.graphDataAccessInterface = graphDataAccessInterface;
        setState(new GraphState(graphDataAccessInterface));
    }
}
