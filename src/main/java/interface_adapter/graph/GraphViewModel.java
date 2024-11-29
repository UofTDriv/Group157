package interface_adapter.graph;

import data_access.InMemoryJourneyDataAccessObject;
import entity.Graph;
import interface_adapter.ViewModel;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultEdge;

public class GraphViewModel extends ViewModel<GraphState> {

    public GraphViewModel(ListenableGraph<String, DefaultEdge> graph) {
        super("Graph");
        setState(new GraphState(graph));
    }
}
