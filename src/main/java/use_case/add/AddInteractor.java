package use_case.add;

import use_case.search.SearchInputData;
import entity.Node;
import use_case.graph.GraphDataAccessInterface;
import use_case.journey.JourneyDataAccessInterface;

public class AddInteractor implements AddInputBoundary {
    private final AddOutputBoundary presenter;

    public AddInteractor(AddOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute(AddInputData inputData) {
        String title = inputData.getTitle();
        AddOutputData outputData = new AddOutputData(title, false);
        presenter.prepareSuccessView(outputData);
    }
}