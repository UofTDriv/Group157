package use_case.open;

public interface OpenOutputBoundary {
    void prepareSuccessView(OpenOutputData openOutputData);

    void prepareFailView(String message);
}
