package data_access;

import entity.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;

import java.util.ArrayList;

public class InMemoryJourneyDataAccessInterface implements JourneyDataAccessInterface, GraphDataAccessInterface {

    private WikiHistory wikiHistory = null;
    private Journey journey = null;
    private final Graph graph = new Graph(new SimpleGraph<>(DefaultEdge.class));


    @Override
    public Graph getGraph() {
        return graph;
    }

    @Override
    public void addNode(Node n) {
        journey.addNode(n);
    }

    @Override
    public void setRootPage(WebPage rootPage) {
        Node root = new Node(rootPage, null, true);
        wikiHistory = new WikiHistory(rootPage.title, root);
        journey = new Journey(root);
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

}
