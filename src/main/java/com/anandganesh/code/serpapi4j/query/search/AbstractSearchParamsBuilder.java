package com.anandganesh.code.serpapi4j.query.search;

import com.anandganesh.code.serpapi4j.client.QueryParamConstants;
import com.anandganesh.code.serpapi4j.client.SearchParamsSupplier;
import com.anandganesh.code.serpapi4j.model.search.AdvancedSearchParams;
import com.anandganesh.code.serpapi4j.model.search.SearchType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.anandganesh.code.serpapi4j.client.QueryParamConstants.*;

/**
 * Created by:
 * User: Anand Ganesh
 * Date: 7/16/21
 * Time: 10:50 PM
 */
public abstract class AbstractSearchParamsBuilder implements SearchParamsSupplier {
    private static final String URL_COMMA = "%2C";

    private final Map<String, String> params = new HashMap<>();

    public AbstractSearchParamsBuilder(String provider) {
        param(QueryParamConstants.PARAM_PROVIDER, provider);
    }

    public AbstractSearchParamsBuilder withSearchItem(String searchItem) {
        return param(getSearchParamName(), searchItem);
    }

    public AbstractSearchParamsBuilder withOffsetLimit(int offset, int limit) {
        return param(PARAM_START, String.valueOf(offset))
                .param(PARAM_NUM, String.valueOf(limit));
    }

    public AbstractSearchParamsBuilder withJsonOutput() {
        return param(PARAM_OUTPUT, "json");
    }

    public AbstractSearchParamsBuilder withHtmlOutput() {
        return param(PARAM_OUTPUT, "html");
    }

    public AbstractSearchParamsBuilder withLocation(String location) {
        return param(PARAM_LOCATION, location);
    }

    public AbstractSearchParamsBuilder withLanguage(String language) {
        return param(PARAM_LANGUAGE, language);
    }

    public AbstractSearchParamsBuilder withCountry(String country) {
        return param(PARAM_COUNTRY, country);
    }

    public AbstractSearchParamsBuilder withSearchType(SearchType searchType) {
        String paramVal = switch (searchType) {
            case IMAGE -> "isch";
            case VID -> "vid";
            case NEWS -> "nws";
            case LOCAL -> "lcl";
            case SHOP -> "shop";
            default -> null;
        };
        if (paramVal != null) {
            param(PARAM_SEARCH_TYPE, paramVal);
        }
        return this;
    }

    public AbstractSearchParamsBuilder withAdvancedSearchParams(AdvancedSearchParams advSearchParams) {
        String advSearchParamStr = switch (advSearchParams) {
            case IMGSZ_MEDIUM -> PARAM_ADVANCED_SEARCH_IMAGE_SIZE_MEDIUM;
            case IMGLIC_COMMON -> PARAM_ADVANCED_SEARCH_IMAGE_LICENSE_COMMON;
            default -> throw new UnsupportedOperationException("advanced search param = "
                    + advSearchParams + " is not supported");
        };
        return paramAppend(PARAM_ADVANCED_SEARCH_PARAMS, advSearchParamStr);
    }

    public AbstractSearchParamsBuilder clearParam(String paramName) {
        params.remove(paramName);
        return this;
    }

    private AbstractSearchParamsBuilder param(String paramName, String paramValue) {
        params.put(paramName, paramValue);
        return this;
    }

    private AbstractSearchParamsBuilder paramAppend(String paramName, String paramValue) {
        String existing = params.get(paramName);
        String newVal = existing == null ? paramValue : existing + URL_COMMA + paramValue;
        params.put(paramName, newVal);
        return this;
    }

    public Map<String, String> build() {
        return Collections.unmodifiableMap(params);
    }

    @Override
    public Map<String, String> get() {
        return build();
    }

    public abstract String getSearchParamName();

    public abstract String getSearchProviderName();
}
