package entity;

public class Journey {
    private final Node rootNode;
    private final String rootPageTitle;
    private final WikiHistory nodeHistory;

    public Journey(Node rootNode, WikiHistory nodeHistory) {
        this.rootNode = rootNode;
        this.rootPageTitle = rootNode.toString();
        this.nodeHistory = nodeHistory;

    }
}
