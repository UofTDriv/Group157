package interface_adapter.graph;

import entity.WebPage;
import interface_adapter.ViewManagerModel;
import interface_adapter.journey.JourneyState;
import interface_adapter.journey.JourneyViewModel;
import use_case.graph.GraphOutputBoundary;
import use_case.graph.GraphOutputData;

public class GraphPresenter implements GraphOutputBoundary {
    private final GraphViewModel viewModel;
    private final ViewManagerModel viewManagerModel;
    private final JourneyViewModel journeyViewModel;

    public GraphPresenter(GraphViewModel viewModel, ViewManagerModel viewManagerModel, JourneyViewModel journeyViewModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.journeyViewModel = journeyViewModel;
    }

    @Override
    public void prepareSuccessView(GraphOutputData data) {
        viewManagerModel.setState(journeyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        JourneyState journeyState = journeyViewModel.getState();
        journeyState.setCurrentPage(data.getTitle(), data.getContent());
    }
}
