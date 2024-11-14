package data_access;

import org.json.JSONObject;
import use_case.search.SearchDataAccessInterface;

import java.util.HashMap;

public class WikipediaAccessObject implements SearchDataAccessInterface {
    private final WebAccessObject webAccessObject;

    public WikipediaAccessObject() {
        webAccessObject = new WebAccessObject("https://en.wikipedia.org/w/api.php");
    }

    // just a little helper to build the parameter hashmap
    private HashMap<String, String> buildParameterMap(String page, String prop) {
        HashMap<String, String> parameterMap = new HashMap<>();

        parameterMap.put("action", "parse");
        parameterMap.put("page", page);
        parameterMap.put("prop", prop);
        parameterMap.put("format", "json");

        return parameterMap;
    }

    // yet another helper to abstract away the API call
    private JSONObject makeWikipediaRequest(String page, String prop) {
        HashMap<String, String> parameterMap = buildParameterMap(page, prop);
        JSONObject response = webAccessObject.getAPIResponse(parameterMap);

        if (!response.isNull("error")) {
            // the HTML request is good but the api call was malformed in some way
            String errorCode = response.getJSONObject("error").getString("code");

            // if no page with that title exists
            if (!errorCode.equals("missingtitle")) {
                throw new RuntimeException(errorCode);
            }

            return null;
        }

        return response.getJSONObject("parse");
    }

    // overloading cause most of the time we just want the text or dont care abt the prop
    private JSONObject makeWikipediaRequest(String page) {
        return makeWikipediaRequest(page, "text");
    }

    /**
     * Return the HTML of the given page
     * Precondition: the page exists
     *
     * @param page the page to be searched
     * @return an html string of the page content
     */
    @Override
    public String getHTML(String page) {
        return makeWikipediaRequest(page).getJSONObject("text").getString("*");
    }

    /**
     * Return the title of the given page
     * Precondition: the page exists
     *
     * @param page the page to be searched
     * @return the title of the page
     */
    @Override
    public String getTitle(String page) {
        return makeWikipediaRequest(page).getString("title");
    }

    /**
     * Returns true if a page with the given title exists, false otherwise.
     *
     * @param page the title to be checked
     * @return if page exists
     */
    @Override
    public Boolean pageExists(String page) {
        return makeWikipediaRequest(page) != null;
    }
}
