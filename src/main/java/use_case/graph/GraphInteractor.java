package use_case.graph;

/**
 * The Graph Interactor.
 */
public class GraphInteractor implements GraphInputBoundary {
    private final GraphOutputBoundary graphPresenter;
    private final GraphDataAccessObject graphDataAccessObject;

    public GraphInteractor(GraphOutputBoundary graphPresenter, GraphDataAccessObject graphDataAccessObject) {
        this.graphPresenter = graphPresenter;
        this.graphDataAccessObject = graphDataAccessObject;
    }

    @Override
    public void addNode(NodeInputData newNode) {

    }

    @Override
    public void switchToRoot() {
        graphPresenter.switchToRoot();
    }


}
