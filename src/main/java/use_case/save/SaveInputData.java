package use_case.save;

import entity.Journey;

public class SaveInputData {
    private final String continueOrClose;
    private final String saveTitle;

    public SaveInputData(String continueOrClose, String saveTitle) {
        this.continueOrClose = continueOrClose;
        this.saveTitle = saveTitle;
    }

    public String getContinueOrClose() { return this.continueOrClose; }

    public String getSaveTitle() { return this.saveTitle; }
}
