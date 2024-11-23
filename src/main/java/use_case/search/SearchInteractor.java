package use_case.search;

import data_access.WikipediaAccessObject;

/**
 * Interactor for the search function.
 */
public class SearchInteractor implements SearchInputBoundary {
    private final SearchDataAccessInterface searchAccessObject;
    private final SearchOutputBoundary presenter;

    public SearchInteractor(SearchOutputBoundary presenter, SearchDataAccessInterface searchAccessObject) {
        this.searchAccessObject = searchAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(SearchInputData inputData) {
        String subject = inputData.getSubject();
        if(!searchAccessObject.pageExists(subject)) {
            presenter.prepareFailView("No matching result!");
        }
        else {
            String title = searchAccessObject.getTitle(subject);
            String content = searchAccessObject.getHTML(subject);

            SearchOutputData outputData = new SearchOutputData(title, content, false);
            presenter.prepareSuccessView(outputData);
        }
    }
}
