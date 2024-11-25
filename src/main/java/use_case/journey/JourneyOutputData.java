package use_case.journey;

import entity.WebPage;

public class JourneyOutputData {

    private final WebPage page;

    public JourneyOutputData(WebPage page) {
        this.page = page;
    }

    public WebPage getPage() {
        return page;
    }
}
