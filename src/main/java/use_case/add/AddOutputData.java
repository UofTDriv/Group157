package use_case.add;

import entity.Graph;

public class AddOutputData {
    private final Graph graph;
    private final boolean useCaseFailed;

    public AddOutputData(Graph graph, boolean useCaseFailed) {
        this.graph = graph;
        this.useCaseFailed = useCaseFailed;
    }

    public Graph getGraph() {
        return graph;
    }

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }
}
