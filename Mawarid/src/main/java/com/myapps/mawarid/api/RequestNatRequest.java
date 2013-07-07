package com.myapps.mawarid.api;

import com.android.volley.Response;
import com.myapps.mawarid.model.Lookup;

import java.util.List;

/**
 * Created by mhewedy on 7/7/13.
 */
public class RequestNatRequest extends LookupRequest {

    private static final String urlParams = "APILookUp.ashx?" +
            "tableName=country&" +
            "valueColumn=code&" +
            "displayColumnAR=Country&" +
            "displayColumnEN=Country_EN&" +
            "condition=%20where%20(Code%20=%200)%20OR%20(Can_IsteqdamFromIndv%20=%201)%20ORDER%20BY%20Nationality%20&" +
            "Language=ar-SA";

    public RequestNatRequest(Response.Listener<List<Lookup>> listener, Response.ErrorListener errorListener) {
        super(urlParams, listener, errorListener);
    }

    @Override
    protected String getEnValueField() {
        return "Country_EN";
    }

    @Override
    protected String getValueField() {
        return "Country";
    }

    @Override
    protected String getCodeField() {
        return "code";
    }
}
