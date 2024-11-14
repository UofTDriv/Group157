package data_access;

import org.json.JSONException;
import org.json.JSONObject;
import use_case.search.SearchDataAccessInterface;

import java.util.HashMap;

public class WikipediaAccessObject implements SearchDataAccessInterface {
    private final WebAccessObject webAccessObject;

    public WikipediaAccessObject() {
        webAccessObject = new WebAccessObject("https://en.wikipedia.org/w/api.php");
    }

    // yet another helper to abstract away the API call
    private JSONObject makeRequest(HashMap<String, String> parameterMap) {
        JSONObject response = webAccessObject.getAPIResponse(parameterMap);

        if (!response.isNull("error")) {
            // the HTML request is good but the api call was malformed in some way
            String errorCode = response.getJSONObject("error").getString("code");
            throw new BadWikiRequestException(errorCode, parameterMap.toString());
        }

        return response.getJSONObject("parse");
    }

    private JSONObject makeParseRequest(String page, String prop) {
        HashMap<String, String> parameterMap = new HashMap<>();

        parameterMap.put("action", "parse");
        parameterMap.put("page", page);
        parameterMap.put("prop", prop);
        parameterMap.put("format", "json");

        return makeRequest(parameterMap);
    }

    // overloading cause most of the time we just want the text or dont care abt the prop
    private JSONObject makeParseRequest(String page) {
        return makeParseRequest(page, "text");
    }

    // just a little helper to build the parameter hashmap
    private JSONObject makeSearchRequest(String searchString, int limit) {
        HashMap<String, String> parameterMap = new HashMap<>();

        parameterMap.put("action", "search");
        parameterMap.put("search", searchString);
        parameterMap.put("limit", String.valueOf(limit));
        parameterMap.put("namespace", "0");
        parameterMap.put("format", "json");

        return makeRequest(parameterMap);
    }

    // more overloading
    private JSONObject makeSearchRequest(String searchString) {
        return makeSearchRequest(searchString, 10);
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
        return makeParseRequest(page).getJSONObject("text").getString("*");
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
        return makeParseRequest(page).getString("title");
    }

    /**
     * Returns true if a page with the given title exists, false otherwise.
     *
     * @param page the title to be checked
     * @return if page exists
     */
    @Override
    public Boolean pageExists(String page) {
        // this function is overwritten but i wanna catch all errors that aren't page not found
        try {
            makeParseRequest(page);
            return true;
        }
        catch (BadWikiRequestException e) {
            if (e.isPageNotFound()) {
                return false;
            } else {
                throw e;
            }
        }
    }
}
