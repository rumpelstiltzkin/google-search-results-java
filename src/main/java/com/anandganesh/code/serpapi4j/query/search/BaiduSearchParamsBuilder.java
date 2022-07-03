package com.anandganesh.code.serpapi4j.query.search;

import static com.anandganesh.code.serpapi4j.client.QueryParamConstants.PARAM_Q;
import static com.anandganesh.code.serpapi4j.client.QueryParamConstants.PROVIDER_BAIDU;

/**
 * Baidu search parameters builder
 */
public class BaiduSearchParamsBuilder extends AbstractSearchParamsBuilder {
  private static final String myProvider = PROVIDER_BAIDU;

  public BaiduSearchParamsBuilder() {
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
