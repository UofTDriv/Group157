package entity;

import java.util.ArrayList;

public class WikiHistory {
    public String getTitle() {
        return title;
    }

    public String title;
    public ArrayList<Node> nodeHistory;

    public WikiHistory(Node rootNode) {
        this.title = rootNode.toString();
        this.nodeHistory = new ArrayList<>();
        nodeHistory.add(rootNode);
    }

    public void add(Node node) {
        nodeHistory.add(node);
    }

    public Node getNode(int id) {
        return nodeHistory.get(id);
    }

    public ArrayList<Node> getWikiHistory() {
        return (ArrayList<Node>) nodeHistory.clone();
    }

    public Node getNode(String title) {
        Node result = null;
        for (Node node : nodeHistory) {
            if (node.getTitle().equals(title)) {
                result = node;
            }
        }
        return result;
    }
}