package interface_adapter.add;

import data_access.InMemoryJourneyDataAccessObject;
import entity.Node;
import interface_adapter.ViewManagerModel;
import interface_adapter.graph.GraphState;
import interface_adapter.graph.GraphViewModel;
import interface_adapter.journey.JourneyViewModel;
import use_case.add.AddOutputBoundary;
import use_case.add.AddOutputData;

import java.util.ArrayList;
import java.util.List;

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
        graphState.addNewNode(title, outputData.getParents(), outputData.getChildren());
        graphViewModel.setState(graphState);
        graphViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(AddOutputData outputData) {

    }
}