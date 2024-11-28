package interface_adapter.graph;

import entity.Graph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

public class GraphState {
    private Graph graph;
    private String addError;

    public GraphState(Graph inMemoryGraph) {
        this.graph = inMemoryGraph;
    }

    public DefaultListenableGraph<String, DefaultEdge> getGraph() {
        return (DefaultListenableGraph<String, DefaultEdge>) graph;
    }

    public void setGraph(DefaultListenableGraph<String, DefaultEdge> graph) {
        this.graph = (Graph) graph;
    }

    public void setSearchError(String error) {
        this.addError = error;
    }

    public String getAddError() {
        return addError;
    }
}