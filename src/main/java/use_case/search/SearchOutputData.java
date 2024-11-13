package use_case.search;

/**
 * Output data for the search use case.
 */
public class SearchOutputData {
    private final String title;
    private final String body;
    private final boolean useCaseFailed;

    public SearchOutputData(String title, String body, boolean useCaseFailed) {
        this.title = title;
        this.body = body;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle() { return this.title; }

    public String getBody() { return this.body; }

    public boolean getUseCaseFailed() { return this.useCaseFailed; }
}
