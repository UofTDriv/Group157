package interface_adapter.add;

import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

public class GraphState {
    private ListenableGraph<String, DefaultEdge> graphT;
    private String addError;

    public GraphState() {
        this.graphT = new DefaultListenableGraph<>(new DefaultDirectedGraph<>(DefaultEdge.class));
//        String v1 = "v1";
//        String v2 = "v2";
//        String v3 = "v3";
//        String v4 = "v4";
//
//        graphT.addVertex(v1);
//        graphT.addVertex(v2);
//        graphT.addVertex(v3);
//        graphT.addVertex(v4);
//
//        graphT.addEdge(v1, v2);
//        graphT.addEdge(v2, v3);
//        graphT.addEdge(v3, v1);
//        graphT.addEdge(v4, v3);
    }

    public ListenableGraph<String, DefaultEdge> getGraphT() {
        return graphT;
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