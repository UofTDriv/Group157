package use_case.save;

public interface SaveInputBoundary {
    /**
     * Executes Save Usecase interactor
     * @param saveInputData saveInputData containing title of WikiHistory
     */

    void execute(SaveInputData saveInputData);
}
