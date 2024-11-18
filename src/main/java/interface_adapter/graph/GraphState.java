package interface_adapter.graph;

import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

public class GraphState {
    private ListenableGraph<String, DefaultEdge> graphT;
    // TODO change this to a graph entity

    public GraphState() {
        this.graphT = new DefaultListenableGraph<>(new DefaultDirectedGraph<>(DefaultEdge.class));
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add some sample data (graph manipulated via JGraphX)
        graphT.addVertex(v1);
        graphT.addVertex(v2);
        graphT.addVertex(v3);
        graphT.addVertex(v4);

        graphT.addEdge(v1, v2);
        graphT.addEdge(v2, v3);
        graphT.addEdge(v3, v1);
        graphT.addEdge(v4, v3);
    }

    public ListenableGraph<String, DefaultEdge> getGraphT() {
        return graphT;
    }
}