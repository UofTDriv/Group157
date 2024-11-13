package interface_adapter.search;

import interface_adapter.ViewModel;

public class SearchViewModel extends ViewModel<SearchState> {

    public static final String TOPTEXT_LABEL = "Search any Wikipedia article!";
    public static final String INFO = "Type the title of any wikipedia article using spaces between words.";
    public static final String SEARCH_BUTTON_LABEL = "Start a new journey";

    public SearchViewModel() {
        super("Search");
        setState(new SearchState());
    }
}
