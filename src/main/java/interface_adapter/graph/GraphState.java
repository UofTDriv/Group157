package interface_adapter.graph;

import data_access.InMemoryJourneyDataAccessObject;
import entity.Node;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.List;

public class GraphState {
    private ListenableGraph<String, DefaultEdge> graphT;
    private String addError;

    public GraphState(ListenableGraph<String, DefaultEdge> graph) {
        this.graphT = graph;
    }

    public ListenableGraph<String, DefaultEdge> getGraphT() {
        return graphT;
    }

    public void setGraphT(ListenableGraph<String, DefaultEdge> graphT) {
        this.graphT = graphT;
    }

    /**
     * Add a new node to the graph and connect it to its parent nodes.
     * @param nodeName name of the existing node
     */
    public void addNewNode(String nodeName, List<String> nodeParents, List<String> nodeChildren) {
        graphT.addVertex(nodeName);
        for(String parentName : nodeParents) {
            graphT.addEdge(parentName, nodeName);
        }
        for (String childName : nodeChildren) {
            graphT.addEdge(nodeName, childName);
        }
    }

    public void setAddError(String error) {
        this.addError = error;
    }

    public String getAddError() {
        return addError;
    }
}