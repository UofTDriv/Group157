package use_case.search;

import entity.Graph;
import entity.WebPage;

/**
 * Output data for the search use case.
 */
public class SearchOutputData {
    private final WebPage rootPage;
    private final boolean useCaseFailed;

    public SearchOutputData(WebPage rootPage, boolean useCaseFailed) {
        this.rootPage = rootPage;
        this.useCaseFailed = useCaseFailed;
    }

    public String getRootTitle() {
        return this.rootPage.title;
    }

    public WebPage getRootPage() {
        return this.rootPage;
    }

    public boolean getUseCaseFailed() { return this.useCaseFailed; }
}
