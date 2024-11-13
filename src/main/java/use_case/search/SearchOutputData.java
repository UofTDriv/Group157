package use_case.search;

/**
 * Output data for the search use case.
 */
public class SearchOutputData {
    private final String title;
    private final String content;

    public SearchOutputData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}
