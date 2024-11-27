package entity;

import java.util.ArrayList;

public class Journey {
    private final Node rootNode;
    private final String rootPageTitle;
    private final WikiHistory wikiHistory;
    private int currentPageIndex;

    public Journey(Node rootNode, WikiHistory wikiHistory) {
        this.rootNode = rootNode;
        this.rootPageTitle = rootNode.toString();
        this.wikiHistory = wikiHistory;
        this.currentPageIndex = 0;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public String getRootPageTitle() {
        return rootPageTitle;
    }

    public void addNode(Node node) {
        wikiHistory.add(node);
        currentPageIndex++;
    }

    public Node getCurrentNode() {
        return wikiHistory.getNode(currentPageIndex);
    }
}
