package interface_adapter.search;

/**
 * The state for the Search View Model.
 */

public class SearchState {
    private String title = "";
    private String searchError;

    public String getTitle() {
        return title;
    }

    public String getSearchError() {
        return searchError;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }
}
