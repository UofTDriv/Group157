package entity;

import java.util.ArrayList;

/**
 * Factory for starting a Journey and all its associated entities from a root webpage
 */
public class JourneyFactory {

    public Journey start (WebPage rootPage, WikiHistory wikiHistory) {
        Node root = new Node(rootPage, null, new ArrayList<>());
        wikiHistory.addNode(root);
        return new Journey(root, wikiHistory);
    }
}
