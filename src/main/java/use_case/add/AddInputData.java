package use_case.add;

import entity.Node;

/**
 * Input Data for the Add Node use case.
 */
public class AddInputData {
    private final String title;

    public AddInputData(String currentPageTitle) {
        this.title = currentPageTitle;
    }

    public String getTitle() {
        return title;
    }
}
