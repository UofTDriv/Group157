package data_access;

import org.json.JSONArray;
import org.json.JSONObject;
import use_case.search.SearchDataAccessInterface;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
            String errorInfo = response.getJSONObject("error").getString("info");
            throw new BadWikiRequestException(errorCode, errorInfo + ": " + parameterMap.toString());
        }

        return response;
    }

    private JSONObject makeParseRequest(String page, String prop) {
        HashMap<String, String> parameterMap = new HashMap<>();

        parameterMap.put("action", "parse");
        parameterMap.put("page", page);
        parameterMap.put("prop", prop);
        parameterMap.put("format", "json");

        return makeRequest(parameterMap).getJSONObject("parse");
    }

    // overloading cause most of the time we just want the text or dont care abt the prop
    private JSONObject makeParseRequest(String page) {
        return makeParseRequest(page, "text");
    }

    // just a little helper to build the parameter hashmap
    private JSONArray makeSearchRequest(String searchString, int limit, String profile) {
        HashMap<String, String> parameterMap = new HashMap<>();

        parameterMap.put("action", "opensearch"); // why they didn't just call it 'search' i will never know
        parameterMap.put("search", searchString);
        parameterMap.put("limit", String.valueOf(limit));
        parameterMap.put("profile", profile);
        parameterMap.put("namespace", "0");
        parameterMap.put("format", "json");

        return makeRequest(parameterMap).getJSONArray("data");
    }

    // more overloading
    public ArrayList<String> getSearchResults(String searchString) {
        JSONArray response = makeSearchRequest(searchString, 10, "engine_autoselect");
        // this will *probably* work. no promises.
        return (ArrayList<String>) (Object) response.getJSONArray(1).toList();
    }

    @Override
    public String autocomplete(String searchString) {
        String encodedString = URLEncoder.encode(searchString, StandardCharsets.UTF_8);
        JSONArray response = makeSearchRequest(encodedString, 1, "fuzzy");
        JSONArray results = response.getJSONArray(1);
        return results.isEmpty() ? null : results.getString(0);
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

    /**
     * Return the links contained in a given page
     * Precondition: the page exists
     *
     * @param page the page id (i.e. with underscores and jazz)
     * @return the title of the page
     */
    public ArrayList<String> getPageLinks(String page) {
        JSONArray links = makeParseRequest(page, "links").getJSONArray("links");

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < links.length(); i++) {
            JSONObject link = links.getJSONObject(i);
            if (link.getInt("ns") == 0) {
                result.add(link.getString("*"));
            }
        }

        return result;
    }
}
