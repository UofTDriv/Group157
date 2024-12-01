package interface_adapter.graph;

import interface_adapter.ViewModel;
import interface_adapter.add.AddState;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultEdge;

public class GraphViewModel extends ViewModel<AddState> {

    public GraphViewModel(ListenableGraph<String, DefaultEdge> graph) {
        super("Graph");
        setState(new AddState(graph));
    }
}
