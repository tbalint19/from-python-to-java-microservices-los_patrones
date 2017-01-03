package Controller;

import com.google.gson.internal.LinkedTreeMap;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by balint on 1/3/17.
 */
public class GoogleApiController extends JsonTransformer{

    private final String API_KEY;
    private final String SERVICE_URL;

    public GoogleApiController() {
        this.API_KEY = "AIzaSyBHcG9di92OUUpCrzLXgq4Er4AlOo1cFV4";
        this.SERVICE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json";
    }

    public double getDistance(String webshop, String target) {
        String params = "?origins=" + webshop + "&destinations=" + target + "&key=" + API_KEY;
        String responseJSON = execute(params);
        double distance = (double)((LinkedTreeMap)((LinkedTreeMap)((ArrayList)((LinkedTreeMap)
                Arrays.asList(((List)parse(responseJSON)
                .get("rows")))
                .get(0)
                .get(0))
                .get("elements"))
                .get(0))
                .get("distance"))
                .get("value");

        return distance;
    }

    private String execute(String url) {
        try {
            URI uri = new URIBuilder(SERVICE_URL + url).build();
            return org.apache.http.client.fluent.Request.Get(uri).execute().returnContent().asString();
        } catch (URISyntaxException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
