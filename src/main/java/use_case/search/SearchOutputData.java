package use_case.search;

/**
 * Output data for the search use case.
 * NOTE: THIS IS A VERY BAREBONES IMPLEMENTATION - SPECIFIC ATTRIBUTES SHOULD BE ALTERED BASED ON WHAT WE WANT TO
 * PUT IN FRONT OF THE USER IN THE VIEW
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
