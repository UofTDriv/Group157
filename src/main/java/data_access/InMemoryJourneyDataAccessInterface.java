package data_access;

import entity.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;

import java.util.ArrayList;

public class InMemoryJourneyDataAccessInterface implements JourneyDataAccessInterface, GraphDataAccessInterface {
    private final JourneyFactory journeyFactory = new JourneyFactory();

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
        journey = journeyFactory.start(rootPage);
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

}
