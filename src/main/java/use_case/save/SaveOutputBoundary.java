package use_case.save;

public interface SaveOutputBoundary {

    /**
     * Prepares success view
     * @param saveOutputData output data
     */
    void prepareSuccessView(SaveOutputData saveOutputData);

    /**
     * Prepares fail view
     * @param errorMessage message explaining usecase failure (failure to save Journey)
     */
    void prepareFailView(String errorMessage);
}
