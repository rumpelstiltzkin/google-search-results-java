package com.anandganesh.code.serpapi4j.query.search;

import static com.anandganesh.code.serpapi4j.client.QueryParamConstants.*;

/**
 * DuckDuckGo search parameters builder
 */
public class DuckDuckGoSearchParamsBuilder extends AbstractSearchParamsBuilder {
    private static final String myProvider = PROVIDER_DUCKDUCKGO;

    public DuckDuckGoSearchParamsBuilder() {
        super(myProvider);
    }

    @Override
    public String getSearchParamName() {
        return PARAM_Q;
    }

    @Override
    public String getSearchProviderName() {
        return myProvider;
    }
}
