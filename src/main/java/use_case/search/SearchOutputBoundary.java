package use_case.search;

/**
 * Output boundary for the search use case.
 */
public interface SearchOutputBoundary {
    /**
     * Prepares the success view for the Search use case.
     * @param outputData the output data
     */
    void prepareSuccessView(SearchOutputData outputData);

    /**
     * Prepares the failure view for the Search use case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
