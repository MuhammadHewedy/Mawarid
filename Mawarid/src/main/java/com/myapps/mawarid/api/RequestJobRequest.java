package com.myapps.mawarid.api;

import com.android.volley.Response;
import com.myapps.mawarid.model.Lookup;

import java.util.List;

/**
 * Created by mhewedy on 7/7/13.
 */
public class RequestJobRequest extends LookupRequest {

    private static final String urlParams = "APILookUp.ashx?" +
            "tableName=JobTitle&" +
            "valueColumn=JobeTitleID&" +
            "displayColumnAR=JobTitleName_ar&" +
            "displayColumnEN=JobTitleName_en&" +
            "condition=%20&" +
            "Language=ar-SA";

    public RequestJobRequest(Response.Listener<List<Lookup>> listener, Response.ErrorListener errorListener) {
        super(urlParams, listener, errorListener);
    }

    @Override
    protected String getEnValueField() {
        return "JobTitleName_en";
    }

    @Override
    protected String getValueField() {
        return "JobTitleName_ar";
    }

    @Override
    protected String getCodeField() {
        return "JobeTitleID";
    }
}
