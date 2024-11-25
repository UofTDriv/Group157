package interface_adapter.save;

import entity.Journey;
import use_case.save.SaveInputBoundary;
import use_case.save.SaveInputData;

public class SaveController {
    private final SaveInputBoundary saveInteractor;

    public SaveController(SaveInputBoundary saveInteractor) {
        this.saveInteractor = saveInteractor;
    }

    public void execute(String title, Journey journey) {
        SaveInputData inputData = new SaveInputData(title, journey);

        saveInteractor.execute(inputData);
    }
}
