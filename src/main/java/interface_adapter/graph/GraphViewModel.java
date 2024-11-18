package interface_adapter.graph;

import interface_adapter.ViewModel;

public class GraphViewModel extends ViewModel<GraphState> {

    public GraphViewModel() {
        super("Graph");
        setState(new GraphState());
    }
}