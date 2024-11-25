package use_case.save;

import entity.Journey;
import entity.WikiHistory;

public interface SaveDataAccessInterface {
    /**
     * Checks if a given wikiHistory exists in the hash map or DB
     * @param title the title of the wikiHistory
     * @return true iff the wikiHistory exists in the hash map or DB
     */
    boolean wikiHistoryExists(String title);

    /**
     * Saves wikiHistory into the hash map or DB, assuming that it does not already exist
     * @param wikiHistory the journey object to be saved
     */
    void save(WikiHistory wikiHistory) throws Exception;

    /**
     * Gets the current wikiHistory object
     * @return The current wikiHistory object
     */
    WikiHistory getCurrentWikiHistory();
}
