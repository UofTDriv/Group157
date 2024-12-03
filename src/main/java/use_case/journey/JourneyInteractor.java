package use_case.journey;

import data_access.BadWikiRequestException;
import entity.Journey;
import entity.Node;
import entity.WebPage;
import use_case.search.SearchDataAccessInterface;

import java.util.ArrayList;

public class JourneyInteractor implements JourneyInputBoundary {
    private final SearchDataAccessInterface searchAccessObject;
    private final JourneyDataAccessInterface journeyAccessObject;
    private final JourneyOutputBoundary presenter;

    public JourneyInteractor(SearchDataAccessInterface searchAccessObject,
                             JourneyDataAccessInterface journeyAccessObject,
                             JourneyOutputBoundary presenter) {
        this.searchAccessObject = searchAccessObject;
        this.journeyAccessObject = journeyAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(JourneyInputData inputData) {

        if(!inputData.getSubject().contains("/wiki/")) {
            presenter.prepareFailView("Not a Wikipedia article link");
        }

        String subject = inputData.getSubject().replaceAll("^/wiki/", "");
        try {
            if (Boolean.FALSE.equals(searchAccessObject.pageExists(subject))) {
                presenter.prepareFailView("No matching result!");
            } else {

                String title = searchAccessObject.getTitle(subject);
                String content = WebPage.cleanWikipediaHTML(searchAccessObject.getHTML(subject));

                ArrayList<String> links = searchAccessObject.getPageLinks(subject);

                Journey journey = journeyAccessObject.getJourney();
                Node parentNode = journey.getCurrentNode();

                Node newNode = Node.createNode(title, content, parentNode, links, false);

                journey.addNode(newNode);

                JourneyOutputData outputData = new JourneyOutputData(title, content);

                presenter.prepareSuccessView(outputData);
            }
        } catch (BadWikiRequestException exception) {
            presenter.prepareFailView("Bad Wiki Request Exception");
        }
    }
}
