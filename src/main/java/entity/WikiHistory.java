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
}