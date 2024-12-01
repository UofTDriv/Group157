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
    private final JourneyDataAccessInterface journeyDataAccessInterface;

    public GraphInteractor(GraphOutputBoundary graphPresenter, GraphDataAccessInterface graphDataAccessInterface,
                           JourneyDataAccessInterface journeyDataAccessInterface) {
        this.graphPresenter = graphPresenter;
        this.graphDataAccessInterface = graphDataAccessInterface;
        this.journeyDataAccessInterface = journeyDataAccessInterface;
    }

    @Override
    public void execute(GraphInputData inputData) {
        Journey journey = journeyDataAccessInterface.getJourney();
        WikiHistory wikiHistory = journeyDataAccessInterface.getWikiHistory();

        Node node = wikiHistory.getNode(inputData.getSubject());
        journey.setCurrentNode(node);

        WebPage webPage = node.getPage();

        GraphOutputData graphOutputData = new GraphOutputData(webPage.title, webPage.content);
        graphPresenter.prepareSuccessView(graphOutputData);
    }
}
