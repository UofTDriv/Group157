package use_case.save;

import entity.Journey;

public class SaveInputData {
    private final String title;
    private final Journey journey;

    public SaveInputData(String title, Journey journey) {
        this.title = title;
        this.journey = journey;
    }

    public String getTitle() {
        return this.title;
    }

    public Journey getJourney() {
        return this.journey;
    }
}
