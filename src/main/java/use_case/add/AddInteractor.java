package use_case.add;

import use_case.search.SearchInputData;
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
        // Use Case Success
        String title = inputData.getTitle();
        // TODO: Record this webpage. This needs the implementation of the Journey or WikiHistory entity.
        AddOutputData outputData = new AddOutputData(title, false);
        presenter.prepareSuccessView(outputData);
         }
    }
}