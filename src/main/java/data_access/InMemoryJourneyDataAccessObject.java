package data_access;

import entity.*;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import use_case.add.AddDataAccessInterface;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;

import java.util.ArrayList;

public class InMemoryJourneyDataAccessObject implements JourneyDataAccessInterface,
        GraphDataAccessInterface, AddDataAccessInterface {

    private WikiHistory wikiHistory = null;
    private Journey journey = null;
    private Graph graph = new Graph(new DefaultDirectedGraph<>(DefaultEdge.class));

    @Override
    public void setRootNode(Node rootNode) {
        wikiHistory = new WikiHistory(rootNode);
        journey = new Journey(rootNode, wikiHistory);
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
    public WikiHistory getWikiHistory() {
        return wikiHistory;
    }

    @Override
    public void reset()  {
        graph.removeAllVertices(graph.vertexSet());
        this.wikiHistory = null;
        this.journey = null;
    }

    @Override
    public Node getNode(String title) {
        return wikiHistory.getNode(title);
    }

    @Override
    public Boolean containsAddedNodeTitle(String title) {
        return graph.containsVertex(title);
    }
}
