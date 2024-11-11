package entity;

import java.util.List;

public class Node {
    public final List<Node> parents;
    public final List<Node> children;

    public Node(List<Node> parents, List<Node> children) {
        // Should we use an array list for 'parents' and 'children'
        this.parents = parents;
        this.children = children;
    }

}
