package interface_adapter.open;

import entity.Node;
import org.jgrapht.alg.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class OpenState {
    // TODO add the list of saved Journey entities

    private final List<Pair<String, List<Node>>> wikiHistoryNodes;

    public OpenState() { this.wikiHistoryNodes = new ArrayList<>(); }

    // For the Save usecase (not Open)
    public void updateHistory(String saveTitle, List<Node> wikiHistoryToBeAdded) {
        wikiHistoryNodes.add(new Pair<>(saveTitle, wikiHistoryToBeAdded));
    }

    // For the Save usecase (not Open)
    public List<Pair<String, List<Node>>> getWikiHistoryNodes() {
        return this.wikiHistoryNodes;
    }


}
