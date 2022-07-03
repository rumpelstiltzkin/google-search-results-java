package com.anandganesh.code.serpapi4j.query.search;

import com.anandganesh.code.serpapi4j.client.SearchParamsSupplier;
import com.anandganesh.code.serpapi4j.exceptions.SerpApiException;
import com.anandganesh.code.serpapi4j.model.ApiKey;
import com.anandganesh.code.serpapi4j.model.responses.SearchResponse;

/**
 * Created by:
 * User: Anand Ganesh
 * Date: 7/15/21
 * Time: 9:12 PM
 */
public class ParamsBasedSearch extends AbstractSerpApiSearch<SearchParamsSupplier> {

    public ParamsBasedSearch(ApiKey apiKey) throws SerpApiException {
        super(apiKey);
    }

    @Override
    public SearchResponse getResult(SearchParamsSupplier searchParamsSupplier) throws SerpApiException {
        return client.search(apiKey, searchParamsSupplier);
    }
}
