package use_case.add;

import entity.Node;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;

public class AddInteractor implements AddInputBoundary {
    private final AddOutputBoundary presenter;
    private final JourneyDataAccessInterface journeyDAO;
    private final GraphDataAccessInterface graph;

    public AddInteractor(AddOutputBoundary presenter, JourneyDataAccessInterface journeyDAO, GraphDataAccessInterface graph) {
        this.presenter = presenter;
        this.journeyDAO = journeyDAO;
        this.graph = graph;
    }

    @Override
    public void execute(AddInputData inputData) {

         Node currNode = journeyDAO.getJourney().getCurrentNode();

         graph.getGraph().addVertex(currNode.getTitle());
        // Use Case Success
//        String title = inputData.getTitle();
//        String content = inputData.getContent();

//        // TODO: Record this webpage. This needs the implementation of the Journey or WikiHistory entity.
//        AddOutputData outputData = new AddOutputData(title, content, false);
        presenter.prepareSuccessView(outputData);

        // TODO: Use Case Fails. This needs the implementation of the Journey or WikiHistory entity
    }
}
