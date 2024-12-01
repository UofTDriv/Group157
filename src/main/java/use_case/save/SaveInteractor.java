package use_case.save;

import entity.Node;
import entity.WebPage;
import entity.WikiHistory;
import org.jgrapht.alg.util.Pair;
import use_case.journey.JourneyDataAccessInterface;

import java.util.ArrayList;

public class SaveInteractor implements SaveInputBoundary {

    private final SaveOutputBoundary closePresenter;
    private final SaveOutputBoundary continuePresenter;
    private final SaveDataAccessInterface saveDataAccessObject;
    private final JourneyDataAccessInterface journeyDataAccessObject;

    public SaveInteractor(SaveOutputBoundary closePresenter,
                          SaveOutputBoundary continuePresenter,
                          SaveDataAccessInterface saveDataAccessObject,
                          JourneyDataAccessInterface journeyDataAccessObject) {

        this.closePresenter = closePresenter;
        this.continuePresenter = continuePresenter;
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
            wikiHistoryNodes.add(Node.createNode(curr.getTitle(), null, curr.getParents().get(0),
                    curr.getChildren(), true));

            // Setting the parents and children for the clone...
            wikiHistoryNodes.get(i).setParents(curr.getParents());
        }
        // Are the WikiHistory nodes already in the database
        // or does the save share the same name as another entry or BOTH?
        Pair<Boolean, Boolean> condition = saveDataAccessObject.wikiHistoryExists(saveTitle, wikiHistoryNodes);


        // Saving the WikiHistory object via the DAO
        if (!condition.getFirst() && !condition.getSecond()) {
            // ur good to go
            saveDataAccessObject.save(saveTitle, wikiHistoryNodes);
            SaveOutputData outputData = new SaveOutputData(saveTitle + " has been added", saveTitle, wikiHistoryNodes);

            if (continueOrClose.equals("continue")) {
                continuePresenter.prepareSuccessView(outputData);
            } else if (continueOrClose.equals("close")) {
                closePresenter.prepareSuccessView(outputData);
                // If the user clicked the "Save and Close" button, we want to reset whatever is in the JourneyDAO to null
                journeyDataAccessObject.reset();
            }

        } else if (!condition.getFirst() && condition.getSecond()) {
            // you've already saved this history!
            if (continueOrClose.equals("continue")) {
                continuePresenter.prepareFailView("You've already saved this history");
            } else if (continueOrClose.equals("close")) {
                closePresenter.prepareFailView("You've already saved this history");
            }

        } else {
            // history by that name already exists
            if (continueOrClose.equals("continue")) {
                continuePresenter.prepareFailView("History by that name already exists");
            } else if (continueOrClose.equals("close")) {
                closePresenter.prepareFailView("History by that name already exists");
            }
        }

    }
}
