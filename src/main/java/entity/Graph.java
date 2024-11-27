package entity;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

public class Graph extends DefaultListenableGraph<String, DefaultEdge> {

    public Graph(DefaultDirectedGraph<String, DefaultEdge> graph) {
        super(graph);
    }

}
