package entity;

import java.util.ArrayList;

public class Journey {
    private final Node rootNode;
    private final String rootPageTitle;
    private final ArrayList<Node> nodeHistory;
    private int currentPageIndex;


    public Journey(Node rootNode) {
        this.rootNode = rootNode;
        this.rootPageTitle = rootNode.toString();
        this.nodeHistory = new ArrayList<>();
        this.nodeHistory.add(rootNode);
        this.currentPageIndex = 0;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public String getRootPageTitle() {
        return rootPageTitle;
    }

    public void addNode(Node node) {
        nodeHistory.add(node);
        currentPageIndex++;
    }

    public Node getCurrentNode() {
        return nodeHistory.get(currentPageIndex);
    }
}
