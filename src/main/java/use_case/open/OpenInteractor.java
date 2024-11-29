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

    @Override
    public void execute(OpenInputData openInputData) {

        String saveTitle = openInputData.getSaveTitle();

        List<Node> wikiHistoryNodes = saveDataAccessObject.getWikiHistory(saveTitle);

        if (wikiHistoryNodes.equals(null)) {
            presenter.prepareFailView();
        } else {
            OpenOutputData outputData = new OpenOutputData();
            presenter.prepareSuccessView(outputData);
        }
    }
}
