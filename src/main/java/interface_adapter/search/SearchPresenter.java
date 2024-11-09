package main.java.interface_adapter.search;

import main.java.use_case.search.SearchOutputBoundary;
import main.java.use_case.search.SearchOutputData;

/**
 * Presenter for the search use case.
 */
public class SearchPresenter implements SearchOutputBoundary {
    @Override
    public void prepareSuccessView(SearchOutputData outputData) {
        // TODO: Implement this method
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // TODO: Implement this method
    }
}
