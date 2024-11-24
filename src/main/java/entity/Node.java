package entity;

import java.util.List;

public class Node {
    private final String title;
    private final WebPage page;
    private final List<Node> parents;
    private final List<Node> children;

    public Node(WebPage page, List<Node> parents, List<Node> children) {
        this.page = page;
        this.title = page.title;
        // Should we use an array list for 'parents' and 'children'
        this.parents = parents;
        this.children = children;
    }

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
