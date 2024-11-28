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
    private final Pair<Boolean, Boolean> trueTrue = new Pair<>(true, true);
    private final Pair<Boolean, Boolean> trueFalse = new Pair<>(true, false);
    private final Pair<Boolean, Boolean> falseTrue = new Pair<>(false, true);
    private final Pair<Boolean, Boolean> falseFalse = new Pair<>(false, false);

    public Pair<Boolean, Boolean> wikiHistoryExists(String saveTitle, List<Node> nodes) {

        for (int i = 0; i < wikiHistoriesNodes.size(); i++) {
            if ((wikiHistoriesNodes.get(i).getFirst().equals(saveTitle)) &&
                    (wikiHistoriesNodes.get(i).getSecond().equals(nodes))) {
                return trueTrue;
            } else if (!(wikiHistoriesNodes.get(i).getFirst().equals(saveTitle)) &&
                    (wikiHistoriesNodes.get(i).getSecond().equals(nodes))) {
                return falseTrue;
            } else if ((wikiHistoriesNodes.get(i).getFirst().equals(saveTitle)) &&
                    !(wikiHistoriesNodes.get(i).getSecond().equals(nodes))) {
                return trueFalse;
            }
        }
        return falseFalse;
    }

    public List<Node> getWikiHistory(String saveTitle) {
        for (int i = 0; i < wikiHistoriesNodes.size(); i++) {
            if (wikiHistoriesNodes.get(i).getFirst().equals(saveTitle)) {
                return wikiHistoriesNodes.get(i).getSecond();
            }
        }
        return null;
    }

    public void save (String saveTitle, List < Node > nodesForHistory) {
        wikiHistoriesNodes.add(new Pair<>(saveTitle, nodesForHistory));
    }
}
