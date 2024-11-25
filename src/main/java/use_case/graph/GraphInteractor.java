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
    public void addNode(NodeInputData newNode) {

    }

    @Override
    public void switchToRoot() {
        graphPresenter.switchToRoot();
    }


}
