package data_access;

import entity.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;
import use_case.save.SaveDataAccessInterface;

import java.util.ArrayList;

public class InMemoryJourneyDataAccessInterface implements JourneyDataAccessInterface, GraphDataAccessInterface, SaveDataAccessInterface {

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
    public void setRootPage(Node rootNode) {
        wikiHistory = new WikiHistory(rootNode);
        journey = new Journey(rootNode, wikiHistory);
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public WikiHistory getWikiHistory() {
        return wikiHistory;
    }


    @Override
    public boolean wikiHistoryExists(String title) {
        return false;
    }

    @Override
    public void save(WikiHistory wikiHistory) throws Exception {

    }

    @Override
    public WikiHistory getCurrentWikiHistory() {
        return null;
    }
}
