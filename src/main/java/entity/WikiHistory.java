package entity;

import java.util.ArrayList;

public class WikiHistory {
    public String title;
    public ArrayList<Node> nodeHistory;

    public WikiHistory(String title, Node rootNode) {
        this.title = title;
        this.nodeHistory = new ArrayList<>();
        nodeHistory.add(rootNode);
    }

    public void add(Node node) {
        nodeHistory.add(node);
    }

    public Node getNode(int id) {
        if (nodeHistory.size() <= id) {
            return nodeHistory.get(id);
        } else {
            return nodeHistory.get(0);
        }
    }

    public ArrayList<Node> getWikiHistory() {
        return (ArrayList<Node>) nodeHistory.clone();
    }

}