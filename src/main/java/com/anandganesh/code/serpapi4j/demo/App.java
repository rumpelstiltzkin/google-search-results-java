package com.anandganesh.code.serpapi4j.demo;

import com.anandganesh.code.serpapi4j.exceptions.SerpApiException;
import com.anandganesh.code.serpapi4j.model.ApiKey;
import com.anandganesh.code.serpapi4j.model.responses.SearchResponse;
import com.anandganesh.code.serpapi4j.query.search.GoogleSearchParamsBuilder;
import com.anandganesh.code.serpapi4j.query.search.ParamsBasedSearch;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws SerpApiException {
        if (args.length != 1) {
            System.out.println("Usage: app <serp api key>");
            System.exit(1);
        }

        // Create a search against a provider like Google using your API-key.
        ParamsBasedSearch paramsBasedSearch = new ParamsBasedSearch(new ApiKey(args[0]));
        GoogleSearchParamsBuilder googleSearchParams = new GoogleSearchParamsBuilder();

        String location = "Austin,Texas";
        System.out.println("find the first Coffee in " + location);
        // parameters
        googleSearchParams.withSearchItem("Coffee").withLocation(location);

        try {
            // Execute search
            SearchResponse searchResponse = paramsBasedSearch.getResult(googleSearchParams);
            // Decode response
            JsonArray results = searchResponse.getJsonObject()
                    .get("local_results").getAsJsonObject()
                    .get("places").getAsJsonArray();
            JsonObject first_result = results.get(0).getAsJsonObject();
            System.out.println("first coffee shop: " + first_result.get("title").getAsString() + " found on Google in " + location);
            paramsBasedSearch.close();
        } catch (SerpApiException | IOException exception) {
            System.out.println(exception.getMessage() + " - while performing search");
            exception.printStackTrace();
        }

        System.exit(0);
    }
}
