package interface_adapter.graph;

import data_access.InMemoryJourneyDataAccessObject;
import entity.Graph;
import interface_adapter.ViewModel;

public class GraphViewModel extends ViewModel<GraphState> {

    public GraphViewModel(InMemoryJourneyDataAccessObject dao) {
        super("Graph");
        setState(new GraphState(dao));
    }
}
