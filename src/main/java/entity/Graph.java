package entity;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.SimpleGraph;

public class Graph extends DefaultListenableGraph<Node, DefaultEdge> {

    public Graph(SimpleGraph<Node, DefaultEdge> graph) {
        super(graph);
    }

}
