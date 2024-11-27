package data_access;

import entity.*;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;
import use_case.save.SaveDataAccessInterface;

public class InMemoryJourneyDataAccessInterface implements JourneyDataAccessInterface,
        GraphDataAccessInterface,
        SaveDataAccessInterface {

    private WikiHistory wikiHistory = null;
    private Journey journey = null;
    private Graph graph = null;

    @Override
    public void setRootPage(Node rootNode) {
        wikiHistory = new WikiHistory(rootNode);
        journey = new Journey(rootNode, wikiHistory);
        graph = new Graph(new DefaultDirectedGraph<>(DefaultEdge.class));
        graph.addVertex(rootNode.toString());
    }

    @Override
    public Graph getGraph() {
        return graph;
    }

    @Override
    public Journey getJourney() {
        return journey;
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
        return wikiHistory;
    }
}
