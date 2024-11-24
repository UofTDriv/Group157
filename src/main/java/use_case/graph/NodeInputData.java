package use_case.graph;

import entity.Node;
import entity.WebPage;

import java.util.List;

public class NodeInputData {
    public final WebPage page;
    public final List<Node> parents;

    public NodeInputData(WebPage page, List<Node> parents) {
        this.page = page;
        this.parents = parents;
    }
}
