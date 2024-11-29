package use_case.search;

import entity.Node;
import entity.WebPage;
import use_case.journey.JourneyDataAccessInterface;

import java.util.ArrayList;

/**
 * Interactor for the search function.
 */
public class SearchInteractor implements SearchInputBoundary {
    private final SearchDataAccessInterface searchAccessObject;
    private final JourneyDataAccessInterface journeyAccessObject;
    private final SearchOutputBoundary presenter;

    public SearchInteractor(SearchOutputBoundary presenter, SearchDataAccessInterface searchAccessObject, JourneyDataAccessInterface journeyAccessObject) {
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
            String content = WebPage.cleanWikipediaHTML(searchAccessObject.getHTML(subject));

            ArrayList<String> links = searchAccessObject.getPageLinks(subject);

            Node root = Node.createNode(title, content, null, links,true);

            journeyAccessObject.setRootNode(root);

            SearchOutputData outputData = new SearchOutputData(title, content, false);
            presenter.prepareSuccessView(outputData);
        }
    }
}
