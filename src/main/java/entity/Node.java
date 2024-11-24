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

}
