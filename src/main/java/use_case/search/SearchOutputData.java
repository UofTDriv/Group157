package use_case.search;

/**
 * Output data for the search use case.
 */
public class SearchOutputData {
    private final String rootPageTitle;
    private final String rootPageContent;
    private final boolean useCaseFailed;

    public SearchOutputData(String rootPageTitle, String rootPageContent,  boolean useCaseFailed) {
        this.rootPageTitle = rootPageTitle;
        this.rootPageContent = rootPageContent;
        this.useCaseFailed = useCaseFailed;
    }

    public String getRootTitle() {
        return this.rootPageTitle;
    }

    public String getRootPageContent() {
        return this.rootPageContent;
    }

    public boolean getUseCaseFailed() {
        return this.useCaseFailed;
    }
}
