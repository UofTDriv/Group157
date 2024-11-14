package use_case.search;

public interface SearchDataAccessInterface {
    /**
     * Checks if there is a Wikipedia page for the subject.
     * @param subject the subject to be checked
     * @return true iff there is a Wikipedia page for the subject
     */
    Boolean subjectExists(String subject);

    /**
     * Returns the web page of the Wikipedia subject in HTML.
     * @param subject the subject to be searched
     * @return HTML of the corresponding webpage
     */
    String getHTML(String subject);

    /**
     * Returns the title of the Wikipedia page.
     * @param subject the subject to be searched
     * @return title of the corresponding webpage
     */
    String getTitle(String subject);
}
