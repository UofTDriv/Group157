package use_case.add;

import use_case.search.SearchInputData;

/**
 * Input Boundary for the Add use case.
 */
public interface AddInputBoundary {
    /**
     * Executes the add node use case: add the current page as a node of the graph.
     * @param inputData the input data
     */
    void execute(AddInputData inputData);
}
