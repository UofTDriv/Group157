package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

/**
 * This class helps to access APIs like the MediaWiki API.
 */
public class WebAccessObject {
    final OkHttpClient client = new OkHttpClient();
    final String url;

    public WebAccessObject(String url) {
        this.url = url;
    }

    private String buildQueryString(Map<String, String> parameters) {
        StringBuilder queryString = new StringBuilder();

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            queryString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        // removing trailing ampersand
        queryString.deleteCharAt(queryString.length() - 1);

        return queryString.toString();
    }

    /**
     * A helper method that gets the JSON response from the API.
     * @param parameters the parameters of the request.
     * @return the JSON response of the API.
     */
    protected JSONObject getAPIResponse(Map<String, String> parameters) {
        // creating the request
        final Request request = new Request.Builder()
                .url(url + "?" + buildQueryString(parameters))
                .build();

        // sending the request, processing the response
        try {
            final Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                return new JSONObject(response.body().string());
            }

            else {
                throw new RuntimeException(response.body().string());
            }
        }
        catch (IOException | JSONException ex) {
            throw new RuntimeException(ex);
        }
    }
}
