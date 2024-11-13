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
        String[] words = articleTitle.split(" ");
        for(int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        String formatString = String.join("_", words);

        final SearchInputData searchInputData = new SearchInputData(formatString);

        searchUsecaseInteractor.execute(searchInputData);
    }
}
