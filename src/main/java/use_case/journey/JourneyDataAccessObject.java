package use_case.journey;

import entity.Journey;
import entity.WebPage;

public interface JourneyDataAccessObject {
    void setRootPage(WebPage r);

    Journey getJourney();
}
