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
 * Created by mhewedy on 7/7/13.
 */
public abstract class LookupRequest extends AbstractRequest<List<Lookup>> {

    public LookupRequest(String urlParams, Response.Listener<List<Lookup>> listener,
                         Response.ErrorListener errorListener) {
        super(Method.GET, urlParams, listener, errorListener);
    }

    @Override
    public List<Lookup> getObjectFromJson(String json) {
        List<Lookup> lookups = new ArrayList<Lookup>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject != null) {
                    lookups.add(new Lookup(jsonObject.getInt(getCodeField()),
                            jsonObject.getString(getValueField()),
                            jsonObject.getString(getEnValueField())));
                }
            }
        } catch (JSONException e) {
            Logger.e(null, e, e.getMessage());
        }
        return lookups;
    }

    protected abstract String getEnValueField();

    protected abstract String getValueField();

    protected abstract String getCodeField();
}
