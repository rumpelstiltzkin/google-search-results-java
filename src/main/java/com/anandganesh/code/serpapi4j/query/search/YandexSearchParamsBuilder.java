package com.anandganesh.code.serpapi4j.query.search;

import static com.anandganesh.code.serpapi4j.client.QueryParamConstants.*;

/**
 * Yandex search parameters builder
 */
public class YandexSearchParamsBuilder extends AbstractSearchParamsBuilder {
  private static final String myProvider = PROVIDER_YANDEX;

  public YandexSearchParamsBuilder() {
    super(myProvider);
  }

  @Override
  public String getSearchParamName() {
    return PARAM_TEXT;
  }

  @Override
  public String getSearchProviderName() {
    return myProvider;
  }
}
