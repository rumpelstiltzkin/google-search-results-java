package com.anandganesh.code.serpapi4j.query.search;

import static com.anandganesh.code.serpapi4j.client.QueryParamConstants.*;

/**
 * Google search parameters builder
 */
public class GoogleSearchParamsBuilder extends AbstractSearchParamsBuilder {
  private static final String myProvider = PROVIDER_GOOGLE;

  public GoogleSearchParamsBuilder() {
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
