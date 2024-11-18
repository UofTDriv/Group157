package entity;

import java.util.List;

public class Node {
    public final String title;
    public final WebPage page;
    public final List<Node> parents;
    public final List<Node> children;
    public final Integer id;

    public Node(WebPage page, List<Node> parents, List<Node> children, Integer id) {
        this.page = page;
        this.title = page.title;
        // Should we use an array list for 'parents' and 'children'
        this.parents = parents;
        this.children = children;
        this.id = id;
    }

}
