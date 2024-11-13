package use_case.search;

import data_access.WebAccessObject;

/**
 * Interactor for the search function.
 */
public class SearchInteractor implements SearchInputBoundary {
    private final WebAccessObject webAccessObject;
    private final SearchOutputBoundary presenter;

    public SearchInteractor(SearchOutputBoundary presenter,
                            WebAccessObject webAccessObject) {
        this.presenter = presenter;
        this.webAccessObject = webAccessObject;
    }

    @Override
    public void execute(SearchInputData inputData) {
        String subject = inputData.getSubject();
        if(!webAccessObject.subjectExists(subject)) {
            presenter.prepareFailView("No matching result.");
        }
        else {
            String title = webAccessObject.getTitle(subject);
            String content = webAccessObject.getHTML(subject);

            SearchOutputData outputData = new SearchOutputData(title, content, false);
            presenter.prepareSuccessView(outputData);
        }
    }
}
