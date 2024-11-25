package use_case.save;

import data_access.InMemorySaveDataAccessObject;
import entity.Journey;
import entity.WikiHistory;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchInteractor;

public class SaveInteractor implements SaveInputBoundary {

    private final SaveOutputBoundary presenter;
    private final SaveDataAccessInterface saveDataAccessObject;

    public SaveInteractor(SaveOutputBoundary presenter, SaveDataAccessInterface saveDataAccessObject) {
        this.presenter = presenter;
        this.saveDataAccessObject = saveDataAccessObject;
    }

    @Override
    public void execute(SaveInputData saveInputData) {

        // Creating the WikiHistory object
        String title = saveInputData.getTitle();
        Journey journey = saveInputData.getJourney();
        WikiHistory wikiHistory = new WikiHistory(title, journey);

        // Saving the WikiHistory object via the DAO
        try {
            saveDataAccessObject.save(wikiHistory);
            SaveOutputData outputData = new SaveOutputData(journey.rootPage + " has been added");
            presenter.prepareSuccessView(outputData);

        } catch (Exception e) {
            presenter.prepareFailView(journey.rootPage + " already exists");
        }


    }
}
