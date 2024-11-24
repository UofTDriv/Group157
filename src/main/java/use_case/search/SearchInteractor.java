package use_case.search;

import data_access.WikipediaAccessObject;
import entity.WebPage;
import use_case.journey.JourneyDataAccessObject;

/**
 * Interactor for the search function.
 */
public class SearchInteractor implements SearchInputBoundary {
    private final SearchDataAccessInterface searchAccessObject;
    private final JourneyDataAccessObject journeyAccessObject;
    private final SearchOutputBoundary presenter;

    public SearchInteractor(SearchOutputBoundary presenter, SearchDataAccessInterface searchAccessObject, JourneyDataAccessObject journeyAccessObject) {
        this.searchAccessObject = searchAccessObject;
        this.journeyAccessObject = journeyAccessObject;
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

            journeyAccessObject.setRootPage(new WebPage(title, content));

            SearchOutputData outputData = new SearchOutputData(title, content, false);
            presenter.prepareSuccessView(outputData);
        }
    }
}
