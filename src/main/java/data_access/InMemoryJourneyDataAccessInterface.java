package data_access;

import entity.*;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;

public class InMemoryJourneyDataAccessInterface implements JourneyDataAccessInterface,
        GraphDataAccessInterface {

    private WikiHistory wikiHistory = null;
    private Journey journey = null;
    private Graph graph = null;

    @Override
    public void setRootNode(Node rootNode) {
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
    public WikiHistory getWikiHistory() { return wikiHistory; }

    @Override
    public void reset()  {
        this.wikiHistory = null;
        this.journey = null;
        this.graph = null;
    }

}
