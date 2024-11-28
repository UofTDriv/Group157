package use_case.open;

import entity.Node;
import use_case.journey.JourneyDataAccessInterface;
import use_case.save.SaveDataAccessInterface;

import java.util.List;

public class OpenInteractor implements OpenInputBoundary {
    private final OpenOutputBoundary presenter;
    private final SaveDataAccessInterface saveDataAccessObject;
    private final JourneyDataAccessInterface journeyDataAccessObject;

    public OpenInteractor(OpenOutputBoundary presenter, SaveDataAccessInterface saveDataAccessObject,
                          JourneyDataAccessInterface journeyDataAccessObject) {
        this.presenter = presenter;
        this.saveDataAccessObject = saveDataAccessObject;
        this.journeyDataAccessObject = journeyDataAccessObject;
    }

    boolean compareHelper(List<Node> nodesInMemory, List<Node> nodesToBeSaved) {
        // return true if the nodes currently in memory are equal to the nodes that the User wants to save
        // (essentially the instance of when the user tries to save the same journey twice

        if (nodesInMemory.size() != nodesToBeSaved.size()) {
            return false;
        } else {
            for (int i = 0; i < nodesInMemory.size(); i++) {
                if (!(nodesInMemory.get(i).getTitle().equals(nodesToBeSaved.get(i).getTitle()))) {
                    return false;
                }
            }
            return true;
        }
    }
    @Override
    public void execute(OpenInputData openInputData) {
        String saveTitle = openInputData.getSaveTitle();

        List<Node> wikiHistoryNodes = saveDataAccessObject.getWikiHistory(saveTitle);

        if (wikiHistoryNodes == null) {
            presenter.prepareFailView("");
        } else if (!(journeyDataAccessObject.getWikiHistory() == null)) {
            if (compareHelper(journeyDataAccessObject.getWikiHistory().nodeHistory, wikiHistoryNodes)) {
                presenter.prepareFailView("You already have this journey open!");
            }
        } else {
            OpenOutputData outputData = new OpenOutputData(wikiHistoryNodes);
            journeyDataAccessObject.setRootNode(wikiHistoryNodes.get(0));

            presenter.prepareSuccessView(outputData);
        }
    }
}
