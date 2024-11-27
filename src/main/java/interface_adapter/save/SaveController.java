package interface_adapter.save;

import use_case.save.SaveInputBoundary;
import use_case.save.SaveInputData;

public class SaveController {
    private final SaveInputBoundary saveInteractor;

    public SaveController(SaveInputBoundary saveInteractor) {
        this.saveInteractor = saveInteractor;
    }

    public void execute(String continueOrClose, String saveTitle) {
        SaveInputData inputData = new SaveInputData(continueOrClose, saveTitle);

        saveInteractor.execute(inputData);
    }
}
