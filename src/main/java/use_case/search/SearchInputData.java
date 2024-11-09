package main.java.use_case.search;

/**
 * Input data for the search use case.
 */
public class SearchInputData {

    private final String searchString;

    public SearchInputData(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }
}
