package entity;

public class Journey {
    private final Node rootNode;
    private final WikiHistory wikiHistory;
    private Node currentNode;

    public Journey(Node rootNode, WikiHistory wikiHistory) {
        this.rootNode = rootNode;
        this.wikiHistory = wikiHistory;
        this.currentNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void addNode(Node node) {
        wikiHistory.add(node);
        currentNode = node;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }
}
