package use_case.graph;

/**
 * The Graph Interactor.
 */
public class GraphInteractor implements GraphInputBoundary {
    private final GraphOutputBoundary graphPresenter;
    private final GraphDataAccessInterface graphDataAccessInterface;

    public GraphInteractor(GraphOutputBoundary graphPresenter, GraphDataAccessInterface graphDataAccessInterface) {
        this.graphPresenter = graphPresenter;
        this.graphDataAccessInterface = graphDataAccessInterface;
    }

    @Override
    public void execute(GraphInputData inputData) {
        // TODO change Journey's currentNode to the one with the inputted title

    }
}
