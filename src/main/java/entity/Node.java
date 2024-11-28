package entity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String title;
    private final WebPage page;
    // Made parents and children not final because needed to set the parents and
    // children for my clones in SaveInteractor
    private List<Node> parents;
    private List<String> children;
    private final boolean addedtoGraph;

    public Node(WebPage page, Node parentNode, ArrayList<String> links, boolean addedtoGraph) {
        this.page = page;
        this.title = page.title;
        this.addedtoGraph = addedtoGraph;
        // Should we use an array list for 'parents' and 'children'
        this.parents = new ArrayList<>();
        this.parents.add(parentNode);
        this.children = links;
    }

    public String getTitle() { return title; }

    public WebPage getPage() {
        return page;
    }

    // These getters and setters are for processing the WikiHistory nodes for saving more efficiently

    public List<Node> getParents() { return parents; }

    public void setParents(List<Node> parents) { this.parents = parents; }

    public ArrayList<String> getChildren() { return (ArrayList<String>) this.children; }

//    public void setChildren(List<Node> children) { this.children = children; }

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
