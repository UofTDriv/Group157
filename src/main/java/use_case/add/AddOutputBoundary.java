package use_case.add;

import use_case.search.SearchOutputData;

public interface AddOutputBoundary {
    /**
     * Prepares the success view for the Add use case.
     * @param outputData the output data
     */
    void prepareSuccessView(AddOutputData outputData);

    /**
     * Prepares the failure view for the Add use case.
     * @param outputData the explanation of the failure
     */
    void prepareFailView(AddOutputData outputData);
}
