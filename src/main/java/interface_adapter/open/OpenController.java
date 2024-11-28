package interface_adapter.open;

import use_case.open.OpenInputBoundary;
import use_case.open.OpenInputData;
import use_case.open.OpenInteractor;

public class OpenController {

    private final OpenInputBoundary openInteractor;

    public OpenController(OpenInputBoundary openInteractor) {
        this.openInteractor = openInteractor;
    }

    public void execute(String saveTitle) {
        OpenInputData inputData = new OpenInputData(saveTitle);

        openInteractor.execute(inputData);
    }
}
