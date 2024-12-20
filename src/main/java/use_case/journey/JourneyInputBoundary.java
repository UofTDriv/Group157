package use_case.journey;

/**
 * Input Boundary for the journey use case.
 */
public interface JourneyInputBoundary {

    /**
     * Executes the journey use case: executes the addition of a new node
     * @param inputData the input data
     */
    void execute(JourneyInputData inputData);
}
