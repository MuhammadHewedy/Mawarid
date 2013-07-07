package com.myapps.mawarid.api;

import com.android.volley.Response;
import com.myapps.mawarid.model.Lookup;

import java.util.List;

/**
 * Created by mhewedy on 7/7/13.
 */
public class SectorRequest extends LookupRequest {


    private static final String urlParams = "APILookUp.ashx?" +
            "tableName=sector&" +
            "valueColumn=SectorID&" +
            "displayColumnAR=SectorName&" +
            "displayColumnEN=SectorName_en&" +
            "condition=%20&" +
            "Language=ar-SA";

    public SectorRequest(Response.Listener<List<Lookup>> listener,
                         Response.ErrorListener errorListener) {
        super(urlParams, listener, errorListener);
    }

    @Override
    protected String getEnValueField() {
        return "SectorName_en";
    }

    @Override
    protected String getValueField() {
        return "SectorName";
    }

    @Override
    protected String getCodeField() {
        return "SectorID";
    }
}
