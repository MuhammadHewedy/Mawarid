package com.myapps.mawarid.api;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.myapps.mawarid.util.Logger;

import java.util.Map;

/**
 * Created by mohammad_abdullah on 7/10/13.
 */
public class SubmitIndividualRequest extends AbstractRequest<Void> {

    private final Map<String, String> mParams;

    public SubmitIndividualRequest(Map<String, String> params, Response.Listener<Void> listener,
                                   Response.ErrorListener errorListener) {
        super(Method.POST, "postdata.ashx", listener, errorListener);
        this.mParams = params;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }

    @Override
    public Void getObjectFromJson(String json) {
        Logger.d(null, "json string response :%s: ", json);
        return null;
    }
}
