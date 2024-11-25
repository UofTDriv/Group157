package entity;

import java.util.ArrayList;

/**
 * Factory for starting a Journey and all its associated entities from a root webpage
 */
public class JourneyFactory {

    public Journey start (WebPage rootPage) {
        Node root = new Node(rootPage, null);
        return new Journey(root);
    }
}
