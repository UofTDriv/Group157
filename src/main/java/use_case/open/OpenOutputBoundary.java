package use_case.open;

import use_case.save.SaveOutputData;

public interface OpenOutputBoundary {
    void prepareSuccessView(OpenOutputData openOutputData);

    void prepareFailView();
}
