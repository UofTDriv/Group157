package interface_adapter.add;

import use_case.add.AddInputBoundary;
import use_case.add.AddInputData;

public class AddController {
    private final AddInputBoundary addInteractor;

    public AddController(AddInputBoundary addInteractor) {
        this.addInteractor = addInteractor;
    }

    /**
     * Executes the add use case.
     */
    public void execute(String title) {
        final AddInputData inputData = new AddInputData(title);
        addInteractor.execute(inputData);
    }
}
