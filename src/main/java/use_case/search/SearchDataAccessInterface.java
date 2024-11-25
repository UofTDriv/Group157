package use_case.search;

import java.util.ArrayList;

public interface SearchDataAccessInterface {
    /**
     * Checks if there is a Wikipedia page with the given title.
     * @param page the title to be checked
     * @return true iff there is a Wikipedia page for the subject
     */
    Boolean pageExists(String page);

    /**
     * Returns the web page of the Wikipedia subject in HTML.
     * @param page the page to be searched
     * @return HTML of the corresponding webpage
     */
    String getHTML(String page);

    /**
     * Returns the title of the Wikipedia page.
     * @param page the page to be searched
     * @return title of the corresponding webpage
     */
    String getTitle(String page);

    ArrayList<String> getPageLinks(String page);
}
