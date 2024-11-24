package entity;

import java.util.ArrayList;

public class WikiHistory {
    private final ArrayList<Node> journeyHistory;

    public WikiHistory(ArrayList<Node> journeyHistory) {
        this.journeyHistory = journeyHistory;
    }

    public void addNode(Node node) {
        journeyHistory.add(node);
    }
}
