package entity;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String title;
    private final WebPage page;
    // Made parents and children not final because needed to set the parents and
    // children for my clones in SaveInteractor
    private List<Node> parents;
    private List<Node> children;
    private final boolean addedtoGraph;

    public Node(WebPage page, Node parentNode, boolean addedtoGraph) {
        this.page = page;
        this.title = page.title;
        this.addedtoGraph = addedtoGraph;
        this.parents = new ArrayList<>();
        this.parents.add(parentNode);
        this.children = new ArrayList<>();
    }

    public String getTitle() { return title; }

    public WebPage getPage() {
        return page;
    }

    // These getters and setters are for processing the WikiHistory nodes for saving more efficiently

    public List<Node> getParents() { return parents; }

    public void setParents(List<Node> parents) { this.parents = parents; }

    public List<Node> getChildren() { return children; }

    public void setChildren(List<Node> children) { this.children = children; }


    // https://jgrapht.org/guide/VertexAndEdgeTypes#vertices-with-attributes state we must implement the following.
    @Override
    public String toString() {
        return title;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Node) && (toString().equals(o.toString()));
    }

}
