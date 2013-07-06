package com.myapps.mawarid.api;

import com.android.volley.Response;
import com.myapps.mawarid.model.Lookup;

import java.util.List;

/**
 * Created by mhewedy on 7/6/13.
 */
public class AgentNationalityLookupRequest extends LookupRequest {

    private static final String urlParams = "APILookUp.ashx?" +
            "tableName=country&" +
            "valueColumn=code&" +
            "displayColumnAR=Country&" +
            "displayColumnEN=Country_EN&" +
            "condition=WHERE%20(Can_IsteqdamToIndv%20=%201)%20AND%20(Code%20>%200)%20ORDER%20BY%20Order_Number,%20Nationality&" +
            "Language=ar-SA";

    public AgentNationalityLookupRequest(Response.Listener<List<Lookup>> listener,
                                         Response.ErrorListener errorListener) {
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
