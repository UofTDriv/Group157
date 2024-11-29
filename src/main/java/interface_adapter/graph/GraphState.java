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

//    /**
//     * Add a new node to the graph.
//     * @param nodeName name of the new node
//     */
//    public void addNewNode(String nodeName) {
//        graphT.addVertex(nodeName);
//    }

    /**
     * Add a new node to the graph and connect it to its parent nodes.
     * @param nodeName name of the existing node
     */
    public void addNewNode(String nodeName) {
        graphT.addVertex(nodeName);
        for(String parentName : getAddedParents(nodeName)) {
            graphT.addEdge(parentName, nodeName);
        }
    }


    /**
     * Return all ancestors of the current node that are added to the graph
     * @param nodeName name of the node
     * @return title of ancestors that are added to the graph
     */
    private List<String> getAddedParents(String nodeName) {
        Node currentNode = dao.getWikiHistory().getNode(nodeName);
        List<String> result = new ArrayList<>();
        for (Node parent : currentNode.getParents()) {
            if (parent.isAddedtoGraph()) {
                result.add(parent.getTitle());
            }
            else {
                result.addAll(getAddedParents(parent.getTitle()));
            }
        }
        return result;
    }

    public void setAddError(String error) {
        this.addError = error;
    }

    public String getAddError() {
        return addError;
    }
}