package use_case.open;

import use_case.save.SaveOutputData;

public interface OpenOutputBoundary {
    void prepareSuccessView(SaveOutputData saveOutputData);

    void prepareFailView();
}
