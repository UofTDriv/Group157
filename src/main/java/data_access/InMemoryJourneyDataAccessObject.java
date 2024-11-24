package data_access;

import entity.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import use_case.graph.GraphDataAccessObject;
import use_case.journey.JourneyDataAccessObject;

import java.util.ArrayList;

public class InMemoryJourneyDataAccessObject implements JourneyDataAccessObject, GraphDataAccessObject {
    private final JourneyFactory journeyFactory = new JourneyFactory();

    private Journey journey = null;
    private final WikiHistory wikiHistory = new WikiHistory(new ArrayList<>());
    private final Graph graph = new Graph(new SimpleGraph<>(DefaultEdge.class));

    @Override
    public Graph getGraph() {
        return graph;
    }

    @Override
    public void addNode(Node n) {
        graph.addVertex(n);
        wikiHistory.addNode(n);
    }

    @Override
    public void setRootPage(WebPage rootPage) {
        journey = journeyFactory.start(rootPage, wikiHistory);
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

}
