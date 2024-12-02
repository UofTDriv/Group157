package use_case.graph;

import entity.Journey;
import entity.Node;
import entity.WebPage;
import entity.WikiHistory;
import interface_adapter.graph.GraphPresenter;
import use_case.journey.JourneyDataAccessInterface;

/**
 * The Graph Interactor.
 */
public class GraphInteractor implements GraphInputBoundary {
    private final GraphOutputBoundary graphPresenter;
    private final GraphDataAccessInterface graphDataAccessInterface;

    public GraphInteractor(GraphOutputBoundary graphPresenter, GraphDataAccessInterface graphDataAccessInterface) {
        this.graphPresenter = graphPresenter;
        this.graphDataAccessInterface = graphDataAccessInterface;
    }

    @Override
    public void execute(GraphInputData inputData) {
        Journey journey = graphDataAccessInterface.getJourney();
        WikiHistory wikiHistory = graphDataAccessInterface.getWikiHistory();

        Node node = wikiHistory.getNode(inputData.getSubject());
        journey.setCurrentNode(node);

        GraphOutputData graphOutputData = new GraphOutputData(node.getTitle(), node.getPage().content);
        graphPresenter.prepareSuccessView(graphOutputData);
    }
}
