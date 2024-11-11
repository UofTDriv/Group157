package use_case.search;

/**
 * Interactor for the search function.
 */
public class SearchInteractor implements SearchInputBoundary {
    private final SearchOutputBoundary presenter;

    public SearchInteractor(SearchOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute(SearchInputData inputData) {
        // TODO: Implement the execute method. This should use the MediaWiki API.
    }
}
