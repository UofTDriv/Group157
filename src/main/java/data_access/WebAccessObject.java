package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.search.SearchDataAccessInterface;

import java.io.IOException;

/**
 * This class helps to access Wikipedia pages using the Wikimedia API.
 */
public class WebAccessObject implements SearchDataAccessInterface {

    @Override
    public String getHTML(String subject) {
        JSONObject response = getAPIResponse(subject);
        return response.getJSONObject("parse").getJSONObject("text").getString("*");
    }

    @Override
    public String getTitle(String subject) {
        JSONObject response = getAPIResponse(subject);
        return response.getJSONObject("parse").getString("title");
    }

    @Override
    public Boolean subjectExists(String subject) {
        JSONObject response = getAPIResponse(subject);
        return response.isNull("error");
    }

    /**
     * A helper method that gets the JSON response from the API.
     * @param subject the subject to be searched.
     * @return the JSON response of the API.
     */
    private JSONObject getAPIResponse(String subject) {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder()
                .url(String.format("https://en.wikipedia.org/w/api.php?action=parse&page=%s&format=json", subject))
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt("status_code") == 200) {
                return responseBody;
            }
            else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        }
        catch (IOException | JSONException ex) {
            throw new RuntimeException(ex);
        }
    }
}
