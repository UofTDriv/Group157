package interface_adapter.add;

import data_access.InMemoryJourneyDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.graph.GraphState;
import interface_adapter.graph.GraphViewModel;
import interface_adapter.journey.JourneyViewModel;
import use_case.add.AddOutputBoundary;
import use_case.add.AddOutputData;

public class AddPresenter implements AddOutputBoundary {

    private final GraphViewModel graphViewModel;
    private final ViewManagerModel viewManagerModel;
    private final JourneyViewModel journeyViewModel;
    private final InMemoryJourneyDataAccessObject dao;

    public AddPresenter(GraphViewModel graphViewModel, ViewManagerModel viewManagerModel,
                        JourneyViewModel journeyViewModel, InMemoryJourneyDataAccessObject dao) {
        this.graphViewModel = graphViewModel;
        this.viewManagerModel = viewManagerModel;
        this.journeyViewModel = journeyViewModel;
        this.dao = dao;
    }

    @Override
    public void prepareSuccessView(AddOutputData outputData) {
        String title = outputData.getTitle();
        final GraphState graphState = graphViewModel.getState();

        dao.getWikiHistory().getNode(title).setAddedtoGraph(true);
        graphState.addNewNode(title);

        graphViewModel.setState(graphState);
        graphViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(AddOutputData outputData) {
      
    }
}