package use_case.add;

import use_case.search.SearchInputData;
import entity.Node;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * The Add Interactor.
 */
public class AddInteractor implements AddInputBoundary {
    private final AddOutputBoundary presenter;
    private final AddDataAccessInterface dao;

    public AddInteractor(AddOutputBoundary presenter, AddDataAccessInterface dao) {
        this.presenter = presenter;
        this.dao = dao;
    }

    @Override
    public void execute(AddInputData inputData) {
        String title = inputData.getTitle();
        dao.getNode(title).setAddedtoGraph(true);

        List<String> parents = getAddedParents(title);
        List<String> children = getAddedChildren(title);

        AddOutputData outputData = new AddOutputData(title, parents, children, false);
        presenter.prepareSuccessView(outputData);
    }

    /**
     * Return all ancestors of the current node that are added to the graph
     * @param nodeName name of the node
     * @return title of ancestors that are added to the graph
     */
    private List<String> getAddedParents(String nodeName) {
        Node currentNode = dao.getNode(nodeName);
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

    private List<String> getAddedChildren(String nodeName) {
        Node currentNode = dao.getNode(nodeName);

        List<String> result = new ArrayList<>();
        for (String link : currentNode.getChildren()) {
            if (dao.containsAddedNodeTitle(link)) {
                result.add(dao.getNode(link).getTitle());
                dao.getNode(link).addParent(currentNode);
            }
        }
        return result;
    }
}