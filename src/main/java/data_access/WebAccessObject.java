package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
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
     * A helper method that gets the JSON response from the API. If the response is a JSONArray, it is
     * wrapped in a JSONObject before being returned.
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

            if (!response.isSuccessful()) {
                throw new RuntimeException(response.body().string());
            }

            String json = response.body().string();
            switch (json.charAt(0)) {
                case '{':
                    return new JSONObject(json);
                case '[':
                    // this is a bodge, but it avoids so much headache if everything's a JSONObject
                    JSONArray jsonArray = new JSONArray(json);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("data", jsonArray);
                    return jsonObject;
                default:
                    throw new JSONException("Could not determine JSON type: " + json);
            }
        }
        catch (IOException | JSONException ex) {
            throw new RuntimeException(ex);
        }
    }
}
