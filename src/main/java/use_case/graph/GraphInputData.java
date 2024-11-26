package use_case.graph;

import entity.Node;
import entity.WebPage;

public class GraphInputData {
    private final Node current;
    private final Node parents;

    public GraphInputData(Node current, Node parent) {
        this.current = current;
        this.parents = parent;
    }
}
