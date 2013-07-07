package com.myapps.mawarid.api;

import com.android.volley.Response;
import com.myapps.mawarid.model.Lookup;

import java.util.List;

/**
 * Created by mhewedy on 7/7/13.
 */
public class HowKnowRequest extends LookupRequest {

    private static final String urlParams = "APILookUp.ashx?" +
            "tableName=howknow&" +
            "valueColumn=howknowid&" +
            "displayColumnAR=howknow_ar&" +
            "displayColumnEN=howknow_en&" +
            "condition=%20&" +
            "Language=ar-SA";

    public HowKnowRequest(Response.Listener<List<Lookup>> listener, Response.ErrorListener errorListener) {
        super(urlParams, listener, errorListener);
    }

    @Override
    protected String getEnValueField() {
        return "howknow_en";
    }

    @Override
    protected String getValueField() {
        return "howknow_ar";
    }

    @Override
    protected String getCodeField() {
        return "howknowid";
    }
}
