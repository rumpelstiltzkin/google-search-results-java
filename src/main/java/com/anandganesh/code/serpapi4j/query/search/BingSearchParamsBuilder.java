package com.anandganesh.code.serpapi4j.query.search;

import static com.anandganesh.code.serpapi4j.client.QueryParamConstants.*;

/**
 * Bing search parameters builder
 */
public class BingSearchParamsBuilder extends AbstractSearchParamsBuilder {
  private static final String myProvider = PROVIDER_BING;

  public BingSearchParamsBuilder() {
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
