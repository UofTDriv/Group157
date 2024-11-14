package interface_adapter.journey;

import entity.Node;
import entity.WebPage;

public class JourneyState {
    // TODO add entity for a Journey
    private boolean addNewPages;
    private Node root;
    private WebPage currentPage;

    public JourneyState() {
        this.addNewPages = false;
        this.root = null;
        this.currentPage = null;
    }

    public boolean isAddNewPages() {
        return addNewPages;
    }

    public void setAddNewPages(boolean addNewPages) {
        this.addNewPages = addNewPages;
    }

}
