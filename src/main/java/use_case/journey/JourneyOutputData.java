package use_case.journey;

import entity.WebPage;

public class JourneyOutputData {

    private final String pageTitle;
    private final String pageContent;

    public JourneyOutputData(String newPageTitle, String newPageContent) {
        this.pageTitle = newPageTitle;
        this.pageContent = newPageContent;
    }

    public String getTitle() {
        return pageTitle;
    }

    public String getPageContent() {
        return pageContent;
    }

}
