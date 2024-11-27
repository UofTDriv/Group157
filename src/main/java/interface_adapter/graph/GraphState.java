package interface_adapter.graph;

import entity.Graph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

public class GraphState {
    private ListenableGraph<String, DefaultEdge> graphT;
    private String addError;

    public GraphState() {
        this.graphT = new DefaultListenableGraph<>(new DefaultDirectedGraph<>(DefaultEdge.class));
    }

    public ListenableGraph<String, DefaultEdge> getGraphT() {
        return graphT;
    }

    public void setGraphT(ListenableGraph<String, DefaultEdge> graphT) {
        this.graphT = graphT;
    }

    public void setSearchError(String error) {
        this.addError = error;
    }

    public String getAddError() {
        return addError;
    }
}