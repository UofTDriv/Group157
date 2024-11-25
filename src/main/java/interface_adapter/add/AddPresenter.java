package interface_adapter.add;

import interface_adapter.ViewManagerModel;
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
        final GraphState graphState = graphViewModel.getState();

        // If this is the start of the journey
        graphState.addNewNode(title);
        // TODO: If this node is navigated from a previous node. This needs us to keep track of the previous page info.

        graphViewModel.setState(graphState);
        graphViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // TODO: Implement after finishing entities
    }
}
