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
    /**
     * Return the links contained in a given page
     * Precondition: the page exists
     * @param page the page id (i.e. with underscores and jazz)
     * @return the title of the page
     */
    ArrayList<String> getPageLinks(String page);

    /**
     * Returns a corrected version of the given title string
     * @param page the erronius page title
     * @return the corrected page title, or null if none were found
     */
    String autocomplete(String page);
}
