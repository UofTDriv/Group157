package interface_adapter.journey;

import entity.Journey;
import entity.WebPage;

public class JourneyState {
    private String currentPageTitle;
    private String currentPageContent;
    private boolean addNewPages;

    public JourneyState() {
        this.addNewPages = false;
        this.currentPageTitle = "No Journey Open";
        this.currentPageContent = "";
    }

    public String getCurrentPageTitle() {
        return currentPageTitle;
    }

    public String getCurrentPageContent() {
        return currentPageContent;
    }

    public void setCurrentPage(String title, String content) {
        this.currentPageTitle = title;
        this.currentPageContent = content;
    }

    public boolean isAddNewPages() {
        return addNewPages;
    }

    public void setAddNewPages(boolean addNewPages) {
        this.addNewPages = addNewPages;
    }
}
