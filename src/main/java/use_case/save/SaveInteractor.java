package use_case.save;

import data_access.InMemorySaveDataAccessObject;
import entity.Journey;
import entity.Node;
import entity.WebPage;
import entity.WikiHistory;
import use_case.journey.JourneyDataAccessInterface;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchInteractor;

import java.util.ArrayList;

public class SaveInteractor implements SaveInputBoundary {

    private final SaveOutputBoundary presenter;
    private final SaveDataAccessInterface saveDataAccessObject;
    private final JourneyDataAccessInterface journeyDataAccessObject;

    public SaveInteractor(SaveOutputBoundary presenter, SaveDataAccessInterface saveDataAccessObject,
                          JourneyDataAccessInterface journeyDataAccessObject) {
        this.presenter = presenter;
        this.saveDataAccessObject = saveDataAccessObject;
        this.journeyDataAccessObject = journeyDataAccessObject;
    }

    @Override
    public void execute(SaveInputData saveInputData) {

        String saveTitle = saveInputData.getSaveTitle();
        String continueOrClose = saveInputData.getContinueOrClose();

        // Creating the WikiHistory object
        WikiHistory wikiHistory = journeyDataAccessObject.getWikiHistory();

        // Processing WikiHistory to make Webpage attribute 'null' (less memory for saving)

        ArrayList<Node> wikiHistoryNodes = new ArrayList<>();
        for (int i = 0; i < wikiHistory.nodeHistory.size(); i++) {
            // Current wikiHistory node
            Node curr = wikiHistory.nodeHistory.get(i);

            // Creating clone of current wikiHistory node with all of the same attributes except WebPage = null
            wikiHistoryNodes.add(new Node(new WebPage(curr.getPage().title, null), curr.getParents().get(0), true));

            // Setting the parents and children for the clone...
            wikiHistoryNodes.get(i).setParents(curr.getParents());
            wikiHistoryNodes.get(i).setChildren(curr.getChildren());

        }

        // If the user clicked the "Save and Close" button, we want to reset whatever is in the JourneyDAO to null
        if (continueOrClose.equals("close")) {
            journeyDataAccessObject.reset();
        }

        // Saving the WikiHistory object via the DAO
        try {
            if (continueOrClose.equals("continue")) {
                saveDataAccessObject.save(saveTitle, wikiHistoryNodes);
                SaveOutputData outputData = new SaveOutputData(saveTitle + " has been added");

                presenter.prepareSuccessViewContinue(outputData);

            } else if (continueOrClose.equals("close")) {
                saveDataAccessObject.save(saveTitle, wikiHistoryNodes);
                SaveOutputData outputData = new SaveOutputData(saveTitle + " has been added");

                presenter.prepareSuccessViewClose(outputData);
            }

        } catch (Exception e) {

            if (continueOrClose.equals("continue")) {
                presenter.prepareFailViewContinue(saveTitle + " already exists");

            } else if (continueOrClose.equals("close")) {
                presenter.prepareFailViewClose(saveTitle + " already exists");
            }
        }


    }
}
