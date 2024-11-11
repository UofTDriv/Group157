package use_case.search;

/**
 * Input Boundary for the search use case.
 */
public interface SearchInputBoundary {
    /**
     * Executes the search use case: update the SearchPresenter to show the corresponding
     * webpage given the input data, or failure info if the input is invalid.
     * @param inputData the input data
     */
    void execute(SearchInputData inputData);
}
