package interface_adapter.add;

import interface_adapter.ViewManagerModel;
import interface_adapter.graph.GraphViewModel;
import interface_adapter.journey.JourneyViewModel;
import use_case.add.AddOutputBoundary;
import use_case.add.AddOutputData;

public class AddPresenter implements AddOutputBoundary {

    private final GraphViewModel graphViewModel;
    private final ViewManagerModel viewManagerModel;
    private final JourneyViewModel journeyViewModel;

    public AddPresenter(GraphViewModel graphViewModel, ViewManagerModel viewManagerModel,
                        JourneyViewModel journeyViewModel) {
        this.graphViewModel = graphViewModel;
        this.viewManagerModel = viewManagerModel;
        this.journeyViewModel = journeyViewModel;
    }

    @Override
    public void prepareSuccessView(AddOutputData outputData) {
        String title = outputData.getTitle();
        final AddState addState = graphViewModel.getState();
        addState.addNewNode(title, outputData.getParents(), outputData.getChildren());
        graphViewModel.setState(addState);
        graphViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(AddOutputData outputData) {

    }
}