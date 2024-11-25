package interface_adapter.graph;

import interface_adapter.ViewManagerModel;
import interface_adapter.journey.JourneyViewModel;
import use_case.graph.GraphOutputBoundary;

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
    public void switchToRoot() {
        viewManagerModel.setState(journeyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
