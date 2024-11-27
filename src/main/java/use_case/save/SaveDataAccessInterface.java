package use_case.save;

import entity.Journey;
import entity.Node;
import entity.WikiHistory;
import org.jgrapht.alg.util.Pair;

import java.util.List;

public interface SaveDataAccessInterface {
    /**
     * Checks if a given wikiHistory exists in the hash map or DB
     * @param saveTitle the title of the wikiHistory
     * @param nodes the list of nodes associated with the title
     * @return true iff the wikiHistory exists in the hash map or DB
     */
    Pair<Boolean, Boolean> wikiHistoryExists(String saveTitle, List<Node> nodes);

    /**
     * Saves wikiHistory into the hash map or DB, assuming that it does not already exist
     * @param saveTitle the title of the wikihistory/journey that the User has provided
     * @param wikiHistoryNodes a CLONE of the wiki history's nodes with the webpage for each node equal to 'null'
     */
    void save(String saveTitle, List<Node> wikiHistoryNodes);
}
