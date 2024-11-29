package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WikiHistory {
    public String title;
    public ArrayList<Node> nodeHistory;
    private Map<String, Node> nodeLookup;

    public WikiHistory(Node rootNode) {
        this.title = rootNode.toString();
        this.nodeHistory = new ArrayList<>();
        nodeHistory.add(rootNode);
        this.nodeLookup = new HashMap<>();
        nodeLookup.put(rootNode.toString(), rootNode);
    }

    public String getTitle() {
        return title;
    }

    public void add(Node node) {
        nodeHistory.add(node);
        nodeLookup.put(node.toString(), node);
    }

    public Node getNodeByIndex(int id) {
        return nodeHistory.get(id);
    }

    public Node getNode(String title) {
        return nodeLookup.get(title);
    }
}