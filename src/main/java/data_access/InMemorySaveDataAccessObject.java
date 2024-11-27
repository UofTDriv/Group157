package data_access;

import entity.Journey;
import entity.Node;
import entity.WikiHistory;
import use_case.save.SaveDataAccessInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemorySaveDataAccessObject implements SaveDataAccessInterface {

    private final Map<String, List<Node>> wikiHistoriesNodes = new HashMap<>();

    public boolean wikiHistoryExists(String title) {
        return wikiHistoriesNodes.containsKey(title);
    }

    public void save(String saveTitle, List<Node> nodesForHistory) {
        wikiHistoriesNodes.put(saveTitle, nodesForHistory);
    }
}
