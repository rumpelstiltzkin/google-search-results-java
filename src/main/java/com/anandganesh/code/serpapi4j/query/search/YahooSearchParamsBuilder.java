package com.anandganesh.code.serpapi4j.query.search;

import static com.anandganesh.code.serpapi4j.client.QueryParamConstants.*;

/**
 * Yahoo search parameters builder
 */
public class YahooSearchParamsBuilder extends AbstractSearchParamsBuilder {
  private static final String myProvider = PROVIDER_YAHOO;

  public YahooSearchParamsBuilder() {
    super(myProvider);
  }

  @Override
  public String getSearchParamName() {
    return PARAM_P;
  }

  @Override
  public String getSearchProviderName() {
    return myProvider;
  }
}
