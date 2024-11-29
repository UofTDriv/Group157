package use_case.open;

import entity.Node;

import java.util.List;

public class OpenOutputData {
    // Note that this is with Webpage = null for each Node
    private final List<Node> wikiHistoryNodes;

    public OpenOutputData(List<Node> wikiHistoryNodes) {
        this.wikiHistoryNodes = wikiHistoryNodes;
    }

    public List<Node> getWikiHistoryNodes() {
        return this.wikiHistoryNodes;
    }
}
