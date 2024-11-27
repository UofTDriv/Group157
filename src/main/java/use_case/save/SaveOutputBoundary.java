package use_case.save;

public interface SaveOutputBoundary {

    /**
     * Prepares success view
     * @param saveOutputData output data
     */
    void prepareSuccessViewContinue(SaveOutputData saveOutputData);

    /**
     * Prepares fail view
     * @param errorMessage message explaining usecase failure (failure to save Journey)
     */
    void prepareFailViewContinue(String errorMessage);

    void prepareSuccessViewClose(SaveOutputData saveOutputData);

    void prepareFailViewClose(String errorMessage);
}
