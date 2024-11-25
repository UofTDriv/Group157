package use_case.journey;

/**
 * Output boundary for the search use case.
 */
public interface JourneyOutputBoundary {
    /**
     * Prepares the success view for the Journey use case.
     * @param outputData the output data
     */
    void prepareSuccessView(JourneyOutputData outputData);

    /**
     * Prepares the failure view for the Journey use case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
