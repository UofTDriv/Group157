package data_access;

import entity.Journey;
import entity.WikiHistory;
import use_case.save.SaveDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemorySaveDataAccessObject implements SaveDataAccessInterface {

    private final Map<String, WikiHistory> wikiHistories = new HashMap<>();

    private String currentWikiHistory;

    public boolean wikiHistoryExists(String title) {
        return wikiHistories.containsKey(title);
    }

    public void save(WikiHistory wikiHistory) throws Exception {
        if (!(wikiHistoryExists(wikiHistory.title))) {
            wikiHistories.put(wikiHistory.title, wikiHistory);
        } else {
            throw new Exception("WikiHistory by that name already exists");
        }

        // What to do if the journey already exists, so it is not overriden? Maybe throw an exception

    }

    public WikiHistory getCurrentWikiHistory() {
        return wikiHistories.get(this.currentWikiHistory);
    }
}
