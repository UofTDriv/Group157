package use_case.search;

/**
 * Input data for the search use case.
 */
public class SearchInputData {

    private final String subject;

    public SearchInputData(String searchString) {
        this.subject = searchString;
    }

    public String getSubject() {
        return this.subject;
    }
}
