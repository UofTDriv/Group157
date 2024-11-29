package interface_adapter.graph;

import data_access.InMemoryJourneyDataAccessObject;
import data_access.InMemorySaveDataAccessObject;
import entity.Graph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

public class GraphState {
    private ListenableGraph<String, DefaultEdge> graphT;
    private String addError;
    private InMemoryJourneyDataAccessObject dao;

    public GraphState(InMemoryJourneyDataAccessObject dao) {
        this.dao = dao;
        this.graphT = dao.getGraph();
    }

    public ListenableGraph<String, DefaultEdge> getGraphT() {
        return graphT;
    }

    public void setGraphT(ListenableGraph<String, DefaultEdge> graphT) {
        this.graphT = graphT;
    }

    /**
     * Add a new node to the graph.
     * @param nodeName name of the new node
     */
    public void addNewNode(String nodeName) {
        graphT.addVertex(nodeName);
    }

    /**
     * Add a new node to the graph and connect it to an exising node.
     * @param nodeName1 name of the existing node
     * @param nodeName2 name of the new node
     */
    public void addNewNode(String nodeName1, String nodeName2) {
        graphT.addVertex(nodeName2);
        graphT.addEdge(nodeName1, nodeName2);
    }

    public void setAddError(String error) {
        this.addError = error;
    }

    public String getAddError() {
        return addError;
    }
}