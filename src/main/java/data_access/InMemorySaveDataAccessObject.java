package data_access;

import entity.Journey;
import entity.Node;
import entity.WikiHistory;
import org.jgrapht.alg.util.Pair;
import use_case.save.SaveDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemorySaveDataAccessObject implements SaveDataAccessInterface {

    private final List<Pair<String, List<Node>>> wikiHistoriesNodes = new ArrayList<>();

    public boolean wikiHistoryExists(String saveTitle) {

        for (int i = 0; i < wikiHistoriesNodes.size(); i++) {
            if (wikiHistoriesNodes.get(i).getFirst().equals(saveTitle)) {
                return true;
            }
        }
        return false;
    }

    public void save(String saveTitle, List<Node> nodesForHistory) {
        wikiHistoriesNodes.add(new Pair<>(saveTitle, nodesForHistory));
    }
}
