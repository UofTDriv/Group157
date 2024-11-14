package use_case.search;

import data_access.WikipediaAccessObject;

/**
 * Interactor for the search function.
 */
public class SearchInteractor implements SearchInputBoundary {
    private final WikipediaAccessObject wikipediaAccessObject;
    private final SearchOutputBoundary presenter;

    public SearchInteractor(SearchOutputBoundary presenter,
                            WikipediaAccessObject wikipediaAccessObject) {
        this.presenter = presenter;
        this.wikipediaAccessObject = wikipediaAccessObject;
    }

    @Override
    public void execute(SearchInputData inputData) {
        String subject = inputData.getSubject();
        if(!wikipediaAccessObject.pageExists(subject)) {
            presenter.prepareFailView("No matching result.");
        }
        else {
            String title = wikipediaAccessObject.getTitle(subject);
            String content = wikipediaAccessObject.getHTML(subject);

            SearchOutputData outputData = new SearchOutputData(title, content, false);
            presenter.prepareSuccessView(outputData);
        }
    }
}
