package com.anandganesh.code.serpapi4j.query.search;

import com.anandganesh.code.serpapi4j.exceptions.SerpApiException;
import com.anandganesh.code.serpapi4j.model.ApiKey;
import com.anandganesh.code.serpapi4j.model.responses.SearchResponse;
import com.anandganesh.code.serpapi4j.query.AbstractSerpApiQuery;

/**
 * Created by:
 * User: Anand Ganesh
 * Date: 7/14/21
 * Time: 7:07 PM
 */
public abstract class AbstractSerpApiSearch<P> extends AbstractSerpApiQuery<SearchResponse, P> {
    protected final ApiKey apiKey;

    public AbstractSerpApiSearch(ApiKey apiKey) throws SerpApiException {
        super();
        this.apiKey = apiKey;
    }

    public abstract SearchResponse getResult(P param) throws SerpApiException;
}
