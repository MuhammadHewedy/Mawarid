package com.myapps.mawarid.api;

import com.android.volley.Response;
import com.myapps.mawarid.model.Lookup;
import com.myapps.mawarid.util.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhewedy on 7/6/13.
 */
public class AgentNationalityLookupRequest extends AbstractRequest<List<Lookup>> {

    private static final String urlParams = "APILookUp" +
            ".ashx?tableName=country&" +
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
    public List<Lookup> getObjectFromJson(String json) {
        List<Lookup> lookups = new ArrayList<Lookup>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject != null) {
                    lookups.add(new Lookup(jsonObject.getInt("code"), jsonObject.getString("Country"),
                            jsonObject.getString("Country_EN")));
                }
            }
        } catch (JSONException e) {
            Logger.e(null, e, e.getMessage());
        }
        return lookups;
    }
}
