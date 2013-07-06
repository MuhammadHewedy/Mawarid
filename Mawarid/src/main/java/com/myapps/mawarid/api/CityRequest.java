package com.myapps.mawarid.api;

import com.android.volley.Response;
import com.myapps.mawarid.model.Lookup;

import java.util.List;

/**
 * Created by mhewedy on 7/7/13.
 */
public class CityRequest extends LookupRequest {

    private static final String urlParams = "APILookUp.ashx?" +
            "tableName=city&" +
            "valueColumn=code&" +
            "displayColumnAR=city&" +
            "displayColumnEN=city_en&" +
            "condition=%20&" +
            "Language=ar-SA";

    public CityRequest(Response.Listener<List<Lookup>> listener, Response.ErrorListener errorListener) {
        super(urlParams, listener, errorListener);
    }

    @Override
    protected String getEnValueField() {
        return "city_en";
    }

    @Override
    protected String getValueField() {
        return "city";
    }

    @Override
    protected String getCodeField() {
        return "code";
    }
}
