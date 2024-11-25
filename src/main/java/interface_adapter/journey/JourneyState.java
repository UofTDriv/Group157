package interface_adapter.journey;

import entity.Journey;
import entity.Node;
import entity.WebPage;

public class JourneyState {
    private Journey journey;
    private WebPage currentPage;
    private boolean addNewPages;

    public JourneyState() {
        this.journey = null;
        this.addNewPages = false;
        this.currentPage = new WebPage("No Journey Open", "");
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public boolean isAddNewPages() {
        return addNewPages;
    }

    public void setAddNewPages(boolean addNewPages) {
        this.addNewPages = addNewPages;
    }

    public String getCurrentPageContent() {
        return currentPage.content;
    }

    public String getCurrentPageTitle() {return currentPage.title; }

    public void setCurrentPage(WebPage currentPage) {
        this.currentPage = currentPage;
    }



}
