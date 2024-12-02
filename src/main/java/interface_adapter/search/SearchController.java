package interface_adapter.search;

import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

/**
 * Controller for the Search use case.
 */
public class SearchController {

    private final SearchInputBoundary searchUsecaseInteractor;

    public SearchController(SearchInputBoundary searchUsecaseInteractor) {
        this.searchUsecaseInteractor = searchUsecaseInteractor;
    }

    /**
     * Executes the Search Use Case
     * @param articleTitle the title of the wikipedia article that the user has provided
     */
    public void execute(String articleTitle) {
        final SearchInputData searchInputData = new SearchInputData(articleTitle);

        searchUsecaseInteractor.execute(searchInputData);
    }
}
