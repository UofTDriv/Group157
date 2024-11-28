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

         if (inputData.getTitle().equals(currNode.getTitle())) {
             currNode.setAddedtoGraph(true);
             graph.getGraph().addVertex(currNode.getTitle());
             AddOutputData outputData = new AddOutputData("Add Success");
             presenter.prepareSuccessView(outputData);
         } else {
             AddOutputData outputData = new AddOutputData("Add Failure");
             presenter.prepareFailView(outputData);
         }
    }
}
