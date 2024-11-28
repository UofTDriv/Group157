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

    /**
     * Add a new node to the graph.
     * @param nodeName name of the new node
     */
    public void addNewNode(String nodeName) {
        graphT.addVertex(nodeName);
    }

    /**
     * Add a new node to the graph and connect it to an exising node.
     * @param nodeName1 name of the existing node
     * @param nodeName2 name of the new node
     */
    public void addNewNode(String nodeName1, String nodeName2) {
        graphT.addVertex(nodeName2);
        graphT.addEdge(nodeName1, nodeName2);
    }


    public void setSearchError(String error) {
        this.addError = error;
    }

    public String getAddError() {
        return addError;
    }
}